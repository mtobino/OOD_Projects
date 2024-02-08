package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A class to represent the behavior of a virus who does not cause symptoms in its victim, but does use it to spread
 *
 * @author Matthew Tobino
 */
public class AsymptomaticBehavior implements InfectionBehavior{
    private static final Random rand = new Random();
    private final int MAX_VIRUS_LIFETIME = rand.nextInt(50);
    private int virusLifetime = 0;
    public AsymptomaticBehavior(){}
    @Override
    public void infect(Field field, Location location) {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object fieldObject = field.getObjectAt(where);
            if(fieldObject instanceof Animal animal)
            {
                if(!animal.getInfectionBehavior().isImmune() && !animal.getInfectionBehavior().isActive()){
                    if(rand.nextInt(100) < ASYMPTOMATIC_CHANCE)
                        animal.setInfectionBehavior(new ActiveVirusBehavior());
                    else
                        animal.setInfectionBehavior(new AsymptomaticBehavior());
                }
            }
        }
    }

    @Override
    public void incrementSeverity(Animal animal) {
        if(animal instanceof Rabbit)
            virusLifetime += 2;
        else
            virusLifetime++;

        if(virusLifetime > MAX_VIRUS_LIFETIME)
        {
            animal.setInfectionBehavior(new ImmuneBehavior());
        }
    }

    @Override
    public void cure(Animal animal) {
    }

    @Override
    public boolean isImmune() {
        return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
