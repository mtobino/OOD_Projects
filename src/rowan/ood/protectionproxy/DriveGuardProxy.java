package rowan.ood.protectionproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Dr. Baliga
 *
 * Dynamic protection proxy class for vehicle objects
 * Below protection proxy enforces "you cannot drive this car"
 * and is created using Java's reflection API
 *
 */

public class DriveGuardProxy implements InvocationHandler {

    Vehicle protectee;
    private DriveGuardProxy(Vehicle vehicle) {
        this.protectee = vehicle;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Intercept drive message and block it; pass everything else to protectee
            if (method.getName().equals("drive")) {
                System.out.println("Car says: You may not drive this car");
                throw new IllegalAccessException();
            } else if (method.getName().equals("getName")) {
                // Intercept getName and change returned name
                return "Protection proxy";
            } else  {
                // Pass everything else through to protectee
                return method.invoke(protectee, args);
            }
    }


    public static Vehicle driveGuard(Vehicle vehicle) {
        return (Vehicle) Proxy.newProxyInstance(
                vehicle.getClass().getClassLoader(),
                vehicle.getClass().getInterfaces(),
                new DriveGuardProxy(vehicle)
        );
    }
}
