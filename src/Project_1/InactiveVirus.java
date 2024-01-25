package Project_1;

/**
 * A class to represent a healthy status, infect method will do nothing in this state.
 */
public class InactiveVirus extends VirusStatus{
    public InactiveVirus(){
        super(false);
    }

    public void infect() {
        // do nothing :D
    }
}
