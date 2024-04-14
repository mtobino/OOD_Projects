package proxy_docker_project;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Locale;
import java.util.Random;

public class GumballServer {
    public static void main(String[] args){
        Random random = new Random();
        try{
            // Create the registry for rmi
            Registry registry = LocateRegistry.createRegistry(1099);

            GumballMachine phillyGumballMachine = new GumballMachine(random.nextInt(5,30));
            GumballMachine atlantaGumballMachine = new GumballMachine(random.nextInt(5,30));
            GumballMachine nycGumballMachine = new GumballMachine(random.nextInt(5,30));

//            GumballWrapper phillyLocation = new GumballWrapper(new GumballMachine(random.nextInt(5,30)),"PHILLY");
//            GumballWrapper atlantaLocation = new GumballWrapper(new GumballMachine(random.nextInt(5,30)),"ATL");
//            GumballWrapper nycLocation = new GumballWrapper(new GumballMachine(random.nextInt(5,30)),"NYC");

            GumballMachine phillyStub = (GumballMachine) UnicastRemoteObject
                    .exportObject(phillyGumballMachine, 0);
            GumballMachine atlantaStub = (GumballMachine) UnicastRemoteObject
                    .exportObject(atlantaGumballMachine, 0);
            GumballMachine nycStub = (GumballMachine) UnicastRemoteObject
                    .exportObject(nycGumballMachine, 0);

            registry.rebind("PHILLY", phillyStub);
            registry.rebind("ATL", atlantaStub);
            registry.rebind("NYC", nycStub);



        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
