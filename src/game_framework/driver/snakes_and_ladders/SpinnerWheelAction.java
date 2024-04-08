package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.PlayerAction;

import java.util.Random;

public class SpinnerWheelAction implements PlayerAction {
    private static final Random rand = new Random();

    /**
     * Spin a spinner with indices between 1 and 6
     *
     * @return an integer number between 1 and 6
     */
    @Override
    public int play() {
        return rand.nextInt(1, 7);
    }
}
