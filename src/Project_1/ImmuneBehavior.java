package Project_1;

/**
 * A class to represent the immune behavior of the virus
 *
 * @author Matthew Tobino
 */
public class ImmuneBehavior implements InfectionBehavior {
    public ImmuneBehavior(){}
    @Override
    public void infect(Field field, Location location) {}

    @Override
    public void incrementSeverity(Animal animal) {}

    @Override
    public void cure(Animal animal) {

    }

    @Override
    public boolean isImmune() {
        return true;
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
