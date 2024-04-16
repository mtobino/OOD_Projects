package proxy_docker_project;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Monitor extends Remote {
    String name = "MONITOR";

    /**
     * Takes in a location and a gumball machine to register into the monitor
     *
     * @param location          where the gumball machine is located
     * @param gumballMachine    the gumball machine that will be monitored
     * @throws RemoteException If the rmi is not set up, the exception is thrown
     */
    void register(String location, GumballMachine gumballMachine) throws RemoteException;

    /**
     * Removes a Gumball Machine from the collection based on the location specified.
     *
     * @param location          Where the gumball machine that is being removed is located
     * @throws RemoteException  If the rmi is not set up, the exception is thrown
     */
    void deregister(String location) throws RemoteException;

    /**
     * Inform the Monitor with a message
     *
     * @param location          The location that is sending the message
     * @param status            The message that the location needs to send to the monitor
     * @throws RemoteException  If the rmi is not set up, the exception is thrown
     */
    void inform(String location, String status) throws RemoteException;

    /**
     * Get the copy of the gumball machine that the monitor is working with
     *
     * @param location          where the gumball machine is located
     * @return                  the gumball machine
     * @throws RemoteException  If the rmi is not set up, the exception is thrown
     */
    GumballMachine getGumballMachine(String location) throws RemoteException;

}
