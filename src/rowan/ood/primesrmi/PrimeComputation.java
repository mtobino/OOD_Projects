package rowan.ood.primesrmi;

/**
 *
 * @author Dr. Baliga
 * Interface for the remote object
 *
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeComputation extends Remote {
    String primeService = "PrimeService";
    String getLargestPrimeFound() throws RemoteException;

}

