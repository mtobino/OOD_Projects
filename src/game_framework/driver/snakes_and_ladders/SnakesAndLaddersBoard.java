package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameBoard;
import game_framework.code_base.Player;

public class SnakesAndLaddersBoard extends GameBoard {

    public SnakesAndLaddersBoard(){
        super();
        setup();

    }
    private void setup(){
        setupPlainTiles();
        setupGoToTiles();
    }
    @Override
    protected boolean winner()
    {
        int boardSize = boardActions.size();
        boolean winner = false;
        for(Player player : players){
            winner |= player.getLocation() == boardSize;
        }
        return winner;
    }

    @Override
    protected int adjustPlayerNewLocation(int playerNewLocation, Player player) {
        if(playerNewLocation > boardActions.size()){
            return player.getLocation();
        }
        return playerNewLocation;
    }

    private void setupPlainTiles(){
        int[] plainTileLocations = {2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20
        , 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40
        , 41, 42, 43, 44, 45, 46, 47, 50, 52, 53, 54, 55, 57, 58, 59, 60
        , 61, 63, 65, 66, 67, 68, 69, 70, 72, 73, 74,75, 76, 77, 78, 79, 81
        , 82, 83, 84, 85, 86, 88, 89, 90, 91, 92, 94, 96, 97, 99, 100};
        for(int location : plainTileLocations){
            boardActions.put(location, new PlainTileAction(location));
        }
    }

    private void setupGoToTiles(){
        // Ladder Tiles
        boardActions.put(1, new GoToAction(38));
        boardActions.put(4, new GoToAction(14));
        boardActions.put(9, new GoToAction(31));
        boardActions.put(21, new GoToAction(42));
        boardActions.put(28, new GoToAction(84));
        boardActions.put(36, new GoToAction(44));
        boardActions.put(51, new GoToAction(67));
        boardActions.put(71, new GoToAction(91));
        boardActions.put(80, new GoToAction(100));

        // Snake tiles
        boardActions.put(16, new GoToAction(6));
        boardActions.put(49, new GoToAction(11));
        boardActions.put(48, new GoToAction(26));
        boardActions.put(56, new GoToAction(53));
        boardActions.put(62, new GoToAction(20));
        boardActions.put(64, new GoToAction(60));
        boardActions.put(87, new GoToAction(24));
        boardActions.put(93, new GoToAction(73));
        boardActions.put(95, new GoToAction(75));
        boardActions.put(98, new GoToAction(78));
    }

}
