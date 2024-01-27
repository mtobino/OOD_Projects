package Project_1;

import java.util.Iterator;
import java.util.List;

public class InfectedRabbit extends Rabbit {
    private final static double INFECTION_RESISTANCE = rand.nextInt(15);
    private final int MAX_INFECTED_STEPS = rand.nextInt(100, 200);
    private int currentInfectedSteps = 0;
    private boolean cured = false;

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     *
     * @param randomAge If true, the rabbit will have a random age.
     * @param field     The field currently occupied.
     * @param location  The location within the field.
     */
    public InfectedRabbit(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    public InfectedRabbit(Rabbit rabbit) {
        super(rabbit);
    }

    @Override
    public void act(List<Animal> newFoxes)
    {
        if(isAlive()){
            attemptCure();
            if(cured){
                Animal rabbit = new Rabbit(new Rabbit(this));
                return;
            }
            infect();
            super.act(newFoxes);
            if(currentInfectedSteps > MAX_INFECTED_STEPS)
            {
                setDead();
            }
            currentInfectedSteps++;
        }

    }
    private void infect()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Fox)
            {
                Fox fox = (Fox) animal;
                InfectedFox infectedFox = new InfectedFox(fox);
                infectedFox.setLocation(fox.getLocation());
                fox.setDead();

            } else if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                InfectedRabbit infectedRabbit = new InfectedRabbit(rabbit);
                infectedRabbit.setLocation(rabbit.getLocation());
                rabbit.setDead();
            }
        }
    }
    private void attemptCure(){
        int possibility = rand.nextInt(100);
        if(possibility <= INFECTION_RESISTANCE)
        {
            cured = true;
        }
    }
}
