package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.BoardActionCommand;
import game_framework.code_base.Player;

public class SnakeTileAction implements BoardActionCommand {
    private final int tileLocation;
    private final int snakeHeight;
    public SnakeTileAction(int snakeHeight, int tileLocation){
        this.snakeHeight = snakeHeight;
        this.tileLocation = tileLocation;
    }
    @Override
    public int execute(Player player) {
        return tileLocation - snakeHeight;
    }
}
