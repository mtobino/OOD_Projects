package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class InfectedFox extends Fox {
    private final static double INFECTION_RESISTANCE = rand.nextInt(20);
    private final int MAX_INFECTED_STEPS = rand.nextInt(100,200);
    private int currentInfectedSteps = 0;
    private boolean cured = false;
    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field     The field currently occupied.
     * @param location  The location within the field.
     */
    public InfectedFox(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    /**
     * Take an existing fox and turn them into an infected fox
     *
     * @param fox   The fox that contracted the disease
     */
    public InfectedFox(Fox fox)
    {
        super(fox);
    }

    @Override
    public void act(List<Animal> newFoxes)
    {
        if(isAlive()){
            attemptCure();
            if(cured){
                Animal fox = new Fox(new Fox(this));
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