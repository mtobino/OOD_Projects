package ProbabilityGame;

import java.util.function.Predicate;

public class CoinSimulation extends SimulationTemp{
    Generator<Boolean> yer;

    public void setYer(){
        yer = new CoinGen();
    }

    @Override
    public void simulate(Predicate predicate) {
        if(predicate.test("yerr"))
            System.out.println("haha");

    }
}
