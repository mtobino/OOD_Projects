package proxy_docker_project;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GumballClient {
    public static void main(String[] args){
        String remoteServerIP = args[0];
        String serviceName = "rmi://" + remoteServerIP + "/";
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = -1;
            System.out.println("Welcome to the Gumball Machine Proxy! Please select which machine you want to " +
                    "view remotely");
            while (choice != 4) {
                System.out.println("1. Philly\n2. Atlanta\n3. NYC\n4. Quit");
                System.out.println("Please select you machine (1/2/3): ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        facilitateGumballCommunication(serviceName, "PHILLY", scanner);
                        break;
                    case 2:
                        facilitateGumballCommunication(serviceName, "ATL", scanner);
                        break;
                    case 3:
                        facilitateGumballCommunication(serviceName, "NYC", scanner);
                        break;
                    case 4:
                        continue;
                    default:
                        System.out.println("Oops you entered a number that isn't an option");
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void facilitateGumballCommunication(String serviceName, String location, Scanner scanner) throws MalformedURLException, NotBoundException, RemoteException {
        String name = serviceName + location;
        System.out.println(name);
        GumballMachine gumballMachineProxy = (GumballMachine) Naming.lookup(name);

    }
}
