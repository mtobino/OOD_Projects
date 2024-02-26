package ProbabilityGame;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args){
        SimulationTemp sim = new CoinSimulation();
        Predicate<String> pred = (p) -> p.equals("yerr");
        sim.simulate(pred);
    }
}
