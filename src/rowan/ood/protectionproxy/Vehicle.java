package rowan.ood.protectionproxy;

/**
 * @author Dr. Baliga
 */

public interface Vehicle {
    void fillGas(double dollars, double pricePerGallon);
    void drive(double miles);
    double milesToEmpty();
    double getGasInTank();
    double getMPG();
    String getName();
}

