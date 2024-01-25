package Project_1;

/**
 * Each Animal is capable of carrying a virus and potentially incfecting other species
 *
 * @author Matthew Tobino
 */
public abstract class VirusStatus {


    boolean canInfect = false;
    public VirusStatus(boolean status){
        this.canInfect = status;
    }
    /**
     * Infect iff the virus is active and able to infect those around it
     */
    public abstract void infect();
}
