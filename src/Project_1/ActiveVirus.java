package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class ActiveVirus implements VirusStatus{
    private static final Random rand = new Random();
    private final int MAX_SEVERITY = rand.nextInt(7);
    private int currentSeverity = 0;
    public ActiveVirus(){
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
                if(!animal1.getVirusStatus().getClass().equals(ImmuneVirus.class)){
                    animal1.setVirusStatus(new ActiveVirus());
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

    @Override
    public void cure(Animal animal) {
        int cureChance = rand.nextInt(100);
        if(cureChance <= 20){
            animal.setVirusStatus(new ImmuneVirus());
        }
    }

}
