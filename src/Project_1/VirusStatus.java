package Project_1;

/**
 * An interface to keep track of the Virus Status of an Animal
 */
public interface VirusStatus {
    /**
     * Infect the surrounding animals, will do nothing in the event that the animal is either immune or does not carry the virus
     *
     * @param field     The current state of the field
     * @param location  The current location of the animal
     */
    void infect(Field field, Location location);

    /**
     * Increment the severity of the infection which will eventually kill the animal
     *
     * @param animal    The animal that is currently afflicted
     */
    void incrementSeverity(Animal animal);

    /**
     * Attempt to cure an animal
     *
     * @param animal    The animal that is currently afflicted
     */
    void cure(Animal animal);

    /**
     * Return whether the animal should be immune or if they are susceptible to the virus
     *
     * @return  true iff the animal is immune
     */
    boolean isImmune();

    /**
     * Returns whether the animal has an active virus
     *
     * @return  true iff the virus is active
     */
    boolean isActive();

}
