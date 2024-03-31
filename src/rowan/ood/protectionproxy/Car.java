package rowan.ood.protectionproxy;

/**
 * @author Dr. Baliga
 */

public class Car implements Vehicle {

    double gasInTank;
    double tankCapacity;
    double milesPerGallon;
    String name;

    public Car (String name, double tankCapacity, double milesPerGallon) {
        this.name = name;
        this.tankCapacity = tankCapacity;
        this.milesPerGallon = milesPerGallon;
    }

    public void fillGas(double dollars, double pricePerGallon) {
        double gallons = dollars/pricePerGallon;
        gasInTank += gallons;
        if (gasInTank > tankCapacity)
            gasInTank = tankCapacity;
    }

    public void drive(double miles) {
        if (miles <= milesToEmpty()) {
            System.out.format ("That was a fun %.2f mile ride\n", miles);
            gasInTank = gasInTank - miles/milesPerGallon;
        }
        else {
            System.out.println("Whoops, you ran out of gas. Call the tow truck");
            gasInTank = 0;
        }
    }

    public double milesToEmpty() {
        return gasInTank*milesPerGallon;
    }

    public double getGasInTank() {
        return gasInTank;
    }

    public double getMPG() {
        return milesPerGallon;
    }

    public String getName() {
        return name;
    }


    // You can protect this object from being driven by providing a
    // protection proxy. Below method creates such a proxy
    public Vehicle getNoDriveProxy() {
        return DriveGuardProxy.driveGuard(this);
    }


}
