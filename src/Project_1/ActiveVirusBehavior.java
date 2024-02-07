package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A class to represent the active behavior of thr virus
 *
 * @author Matthew Tobino
 */
public class ActiveVirusBehavior implements InfectionBehavior {
    private static final Random rand = new Random();
    private final int MAX_SEVERITY = rand.nextInt(50);
    private static final int CURE_CHANCE = 15;
    private int currentSeverity = 0;
    public ActiveVirusBehavior(){
    }

    @Override
    public void infect(Field field, Location location) {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object fieldObject = field.getObjectAt(where);
            if(fieldObject instanceof Animal animal)
            {
                if(!animal.getVirusStatus().isImmune() && !animal.getVirusStatus().isActive()){
                    if(rand.nextInt(100) < ASYMPTOMATIC_CHANCE)
                        animal.setVirusStatus(new ActiveVirusBehavior());
                    else
                        animal.setVirusStatus(new AsymptomaticBehavior());
                }
            }
        }
    }

    @Override
    public void incrementSeverity(Animal animal)
    {
        if(animal instanceof Rabbit)
            currentSeverity += 2;
        else
            currentSeverity++;

        if(currentSeverity > MAX_SEVERITY)
        {
            animal.setDead();
        }
    }

    public void cure(Animal animal) {
        int cureChance = rand.nextInt(100);
        if(cureChance <= CURE_CHANCE){
            animal.setVirusStatus(new ImmuneBehavior());
        }
    }

    public boolean isImmune() {
        return false;
    }

    public boolean isActive() {
        return true;
    }

}
