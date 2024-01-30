package Project_1;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Coronavirus extends Animal{

    // Characteristics shared by all foxes (class variables).

    // The age at which a virus can start to breed.
    private static final int BREEDING_AGE = 10;
    // The age to which a virus can live.
    private static final int MAX_AGE = 20;
    // The likelihood of a virus breeding.
    private static final double BREEDING_PROBABILITY = 0.16;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 1;
    // The food value of a single animal. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int ANIMAL_FOOD_LEVEL = 4;
    // A shared random number generator to control breeding.
    protected static final Random rand = Randomizer.getRandom();

    // Individual characteristics (instance fields).
    // The virus' age.
    private int age;
    // The virus' food level, which is increased by eating animals.
    private int foodLevel;
    /**
     * Create a new virus at location in field.
     *
     * @param field    The field currently occupied.
     * @param location The location within the field.
     */
    public Coronavirus(boolean randomAge, Field field, Location location, VirusStatus virusStatus) {
        super(field, location, virusStatus);
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt(ANIMAL_FOOD_LEVEL);
        }
        else {
            age = 0;
            foodLevel = ANIMAL_FOOD_LEVEL;
        }
    }


    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param newViruses A list to return newly born foxes.
     */
    public void act(List<Animal> newViruses)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newViruses);
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Look for rabbits adjacent to the current location.
     * Only the first live rabbit is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit || animal instanceof Fox) {
                Animal food = (Animal) animal;
                if(food.isAlive()) {
                    food.setDead();
                    foodLevel = ANIMAL_FOOD_LEVEL;
                    return where;
                }
            }
        }
        return null;
    }

    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newViruses A list to return newly born foxes.
     */
    private void giveBirth(List<Animal> newViruses)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Coronavirus young = new Coronavirus(false, field, loc, new ActiveVirus());
            newViruses.add(young);
        }
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }
}
