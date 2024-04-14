package rowan.ood.primesrmi;

/**
 * @author Dr. Baliga
 */

import java.rmi.Naming;
import static java.lang.Thread.sleep;


public class Client {

    public static void main(String ... args) {
        String remoteServerIP = args[0];
        String serviceName = PrimeComputation.primeService;

        try {
            String name = "rmi://" + remoteServerIP + "/" + serviceName;

            // First look up the remote object
            // The RMI api returns a proxy object if lookup is successful
            PrimeComputation proxy = (PrimeComputation) Naming.lookup(name);

            while (true) {
                System.out.format("Largest prime number found so far: %s\n",
                        proxy.getLargestPrimeFound());

                sleep(3000);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
