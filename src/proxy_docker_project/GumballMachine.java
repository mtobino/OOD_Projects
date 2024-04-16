package proxy_docker_project;

import java.io.Serializable;
import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GumballMachine implements Serializable {
 
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
 
	State state = soldOutState;
	int count = 0;
 
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}
 
	public void insertQuarter() {
		state.insertQuarter();
	}
 
	public void ejectQuarter() {
		state.ejectQuarter();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }
	public void update(int count, State state){
		this.count = count;
		this.state = state;
	}
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

	public static void main(String[] args){
		Random random = new Random();
		GumballMachine gumballMachine = new GumballMachine(random.nextInt(5, 15));
		String remoteServerIP = args[0];
		String serviceName = Monitor.name;

		try (Scanner scanner = new Scanner(System.in)){
			String name = "rmi://" + remoteServerIP + "/" + serviceName;

			// First look up the remote object
			// The RMI api returns a proxy object if lookup is successful
			Monitor proxy = (Monitor) Naming.lookup(name);

			System.out.print("Where is this machine located: ");
			String location = scanner.next();

			proxy.register(location, gumballMachine);

			//System.out.println("Current Gumball Machine status");
			//proxy.inform(location, "I exist");
			while (gumballMachine.count > 0){
				GumballMachine local = proxy.getGumballMachine(location);
				gumballMachine.update(local.getCount(), local.getState());
				sleep(2000);
			}
			System.out.println("Monitor used up all the gumballs");
			proxy.inform(location, "There are no more gumballs at this location, machine needs to be refilled");
			proxy.deregister(location);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
