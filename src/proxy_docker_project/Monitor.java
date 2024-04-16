package proxy_docker_project;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Monitor extends Remote {
    String name = "MONITOR";
    void register(String location, GumballMachine gumballMachine) throws RemoteException;
    void deregister(String location) throws RemoteException;
    void inform(String location, String status) throws RemoteException;
    GumballMachine getGumballMachine(String location) throws RemoteException;

}
