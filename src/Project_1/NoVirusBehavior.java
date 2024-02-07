package Project_1;

/**
 * A class to represent the behavior of an animal who has never seen the virus
 *
 * @author Matthew Tobino
 */
public class NoVirusBehavior implements InfectionBehavior {
    public NoVirusBehavior(){}
    public void infect(Field field, Location location) {}
    public void incrementSeverity(Animal animal) {}

    public void cure(Animal animal) {

    }
    public boolean isImmune() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

}
