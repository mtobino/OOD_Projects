package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameBoard;
import game_framework.code_base.Player;

public class SnakesAndLaddersBoard extends GameBoard {
    private int boardSize;
    @Override
    protected boolean winner()
    {
        boolean winner = false;
        for(Player player : players){
            winner |= player.getLocation() == boardSize;
        }
        return winner;
    }

    @Override
    protected int adjustPlayerNewLocation(int playerNewLocation) {
        if(playerNewLocation > boardSize){
            return 0;
        }
        return playerNewLocation;
    }

    private void setupTiles(){
        for(int i = 0; i < boardSize; i++){
            boardActions.put(i, new PlainTileAction());
        }
    }
}
