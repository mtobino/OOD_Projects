package Project_1;

/**
 * A interface to keep track of the Virus Status of an Animal
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

}
