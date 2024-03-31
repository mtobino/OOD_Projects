package rowan.ood.protectionproxy;

/**
 * @author Dr. Baliga
 */

public class Driver {

    static void print(Vehicle car) {
        System.out.format("Name: %s # MPG: %.2f \nGas in tank : %.2f gallons # Miles to empty: %.2f miles\n",
                car.getName(),
                car.getMPG(),
                car.getGasInTank(),
                car.milesToEmpty());
    }

    static void testDrive(Vehicle car) {
        print(car);
        System.out.println("\nTrying to take the car out for a ride ... ");
        try {
            System.out.format("Gas in tank before drive: %f\n", car.getGasInTank());
            car.drive(100);
            System.out.println("Test drive successful\n");
            System.out.format("Gas in tank after drive: %f\n", car.getGasInTank());
        }
        catch (Exception exception) {
            System.out.println("Test drive failed\n");
        }
        System.out.println("After test drive ... ");
        print(car);
    }

    public static void main (String ... args) {
        // Create a car and test drive it
        Car car = new Car("Elmer's car", 20, 25);
        car.fillGas(20, 2.50);
        testDrive(car);

        System.out.println("\n*********** Now protecting vehicle ***********\n");

        // Create protection proxy for car and test drive it
        Vehicle protectedCar = car.getNoDriveProxy();
        testDrive(protectedCar);

    }

}
