package Project_1;

/**
 * A interface to keep track of the Virus Status of an Animal
 */
public interface VirusStatus {
    /**
     * Infect the surrounding animals, will do nothing in the event that the animal is either immune or does not carry the virus
     */
    void infect();

}
