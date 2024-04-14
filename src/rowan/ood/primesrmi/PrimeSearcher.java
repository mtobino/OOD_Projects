package rowan.ood.primesrmi;

/**
 * @author Dr. Baliga
 * Implementation of the remote proxy object
 */

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class PrimeSearcher implements PrimeComputation {

    String largest;
    int a, b;

    // Generate primes of the form (a + nb).
    // If a and b are relatively prime (i.e. gcd(a,b)=1), then
    // Dirichlet's theorem guarantees that there are infinitely many
    // prime numbers of this form
    public PrimeSearcher(int a, int b) throws RemoteException {
        super();
        this.a = a;
        this.b = b;
        largest = "No primes found so far";
    }

    public String getLargestPrimeFound() throws RemoteException {
        return largest;
    }

    void startSearch() {

        final int Certainty = 20;
        BigInteger number = new BigInteger("" + a);
        BigInteger bb = new BigInteger("" + b);

        // Keep searching forever for prime numbers within
        // the arithmetic sequence a, a + b, a + 2b, a + 3b , ...
        // For example, when a = 3, b = 5
        // the sequence would be 3, 8, 13, 18, 23, .....


        while (true) {
            try {
                // Run the Miller Rabin prime number test to
                // check if the number is prime
                if (number.isProbablePrime(Certainty))
                    largest = number.toString();
                number = number.add(bb);
                sleep(1000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {

        String service;
        int a, b;

        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);

        try {

            // Create the RMI registry which provides the functionality
            // for looking up an RMI service hosted at a computer
            Registry registry = LocateRegistry.createRegistry(1099);

            // Create the prime search object. This object
            // actually provides the service and is proxied
            PrimeSearcher primeSearcher = new PrimeSearcher(a, b);

            // Create the proxy object and install it for providing
            // the service over the network
            PrimeComputation stub = (PrimeComputation) UnicastRemoteObject
                    .exportObject(primeSearcher, 0);

            // Ask the registry to host this service
            registry.rebind(PrimeComputation.primeService, stub);

            // Start prime number search
            primeSearcher.startSearch();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
