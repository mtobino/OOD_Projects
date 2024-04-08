package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.BoardActionCommand;
import game_framework.code_base.Player;

public class LadderTileAction implements BoardActionCommand {
    private final int tileLocation;
    private final int ladderHeight;
    public LadderTileAction(int ladderHeight, int tileLocation){
        this.ladderHeight = ladderHeight;
        this.tileLocation = tileLocation;
    }
    @Override
    public int execute(Player player) {
        return ladderHeight + tileLocation;
    }
}
