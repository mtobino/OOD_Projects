package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class ActiveVirusBehavior implements InfectionBehavior {
    private static final Random rand = new Random();
    private final int MAX_SEVERITY = rand.nextInt(50);
    private int currentSeverity = 0;
    public ActiveVirusBehavior(){
    }

    @Override
    public void infect(Field field, Location location) {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Animal animal1)
            {
                if(!animal1.getVirusStatus().isImmune() && !animal1.getVirusStatus().isActive()){
                    animal1.setVirusStatus(new ActiveVirusBehavior());
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
        if(cureChance <= 15){
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
