package proxy_docker_project;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import static java.lang.Thread.sleep;


public class GumballMonitor implements Monitor {
    //private GumballMachine gumballMachine;
    private Map<String, GumballMachine> gumballMachineMap;

    public GumballMonitor() throws RemoteException{
        gumballMachineMap = new HashMap<>();
    }


    @Override
    public void register(String location, GumballMachine gumballMachine) {
        gumballMachineMap.put(location, gumballMachine);
        //this.gumballMachine = gumballMachine;
        System.out.println("Location Added: " + location);
        System.out.println(gumballMachineMap.get(location));
        System.out.println("Location Added Successfully");
    }

    @Override
    public void deregister(String location) {
        GumballMachine removedGumballMachine =  gumballMachineMap.remove(location);
        System.out.println("Removing location: " + location);
        System.out.println(removedGumballMachine);

    }
    public GumballMachine getGumballMachine(String location){
        return gumballMachineMap.get(location);
    }

    @Override
    public void inform(String location, String status)
    {
        System.out.format("%s: %s\n", location, status);
        GumballMachine gumballMachine = gumballMachineMap.get(location);
        System.out.println(gumballMachine);
    }

    public String toString() {
        return "Gumball Machine Monitor watching:\n " ;
    }

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            // Create the registry for rmi
            Registry registry = LocateRegistry.createRegistry(1099);

            GumballMonitor gumballMonitor = new GumballMonitor();

            // create the stubs for proxying
            Monitor monitorStub = (Monitor) UnicastRemoteObject
                    .exportObject(gumballMonitor, 0);

            // bind the stubs in the registry
            registry.rebind(Monitor.name, monitorStub);

            int choice = -1;
            System.out.println("Welcome to your Gumball Machine Monitor! " +
                    "Please select which machine you want to view remotely");
            while (choice != 4) {
                System.out.println("1. Philly\n2. Atlanta\n3. NYC\n4. Quit");
                System.out.println("Please select you machine (1/2/3): ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        facilitateGumballCommunication(gumballMonitor, "PHI", scanner);
                        break;
                    case 2:
                        facilitateGumballCommunication(gumballMonitor, "ATL", scanner);
                        break;
                    case 3:
                        facilitateGumballCommunication(gumballMonitor, "NYC", scanner);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Oops you entered a number that isn't an option");
                        break;

                }
                System.out.println();

            }
            System.out.println("Thank you for monitoring your machines");


        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void facilitateGumballCommunication(GumballMonitor gumballMonitor, String location, Scanner scanner) throws RemoteException, InterruptedException {
        GumballMachine gumballMachine = gumballMonitor.getGumballMachine(location);
        if(gumballMachine == null){
            System.out.println("Machine is out of service\n");
        }
        else{
            int choice = -1;
            System.out.println("Location: " + location);
            while(choice != 3){
                int count = gumballMachine.getCount();
                if(count <= 0){
                    System.out.println("This gumball machine is out of gumballs and will be deregistered shortly" +
                            ", returning you to the main menu...");
                    sleep(2500);
                    return;
                }
                System.out.println(count + " gumball left");
                System.out.println("1. Enter a quarter\n2. Dispense a gumball\n3. Leave this location");
                System.out.println("Enter you choice (1/2/3): ");
                choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        gumballMachine.insertQuarter();
                        break;
                    case 2:
                        gumballMachine.turnCrank();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Oops you entered a number that isn't an option");
                        break;
                }
                System.out.println();
            }
        }
    }
}
