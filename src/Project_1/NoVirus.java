package Project_1;

public class NoVirus implements VirusStatus{
    public NoVirus(){}
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
