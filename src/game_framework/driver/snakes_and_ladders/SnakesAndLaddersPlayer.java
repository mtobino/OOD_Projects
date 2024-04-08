package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.Player;
import game_framework.code_base.PlayerAction;

public class SnakesAndLaddersPlayer extends Player {
    public SnakesAndLaddersPlayer(String name) {
        super(name);
    }

    public SnakesAndLaddersPlayer(String name, PlayerAction playerAction) {
        super(name, playerAction);
    }

    @Override
    public int play() {
        int rollTo = playerAction.play();
        return 0;
    }
}
