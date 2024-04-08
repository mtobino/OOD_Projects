package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.TileActionCommand;
import game_framework.code_base.GameBoard;
import game_framework.code_base.Player;

public class SnakesAndLaddersBoard extends GameBoard {

    public SnakesAndLaddersBoard(){
        super();
        setup();

    }

    @Override
    protected void displayResults() {
        int boardSize = tileActions.size();
        for(Player player : players){
            if(player.getLocation() == boardSize){
                System.out.println(player.getName() + " won the game!");
            }
            else{
                System.out.println(player.getName() + " lost the game. They were at tile " + player.getLocation());
            }
        }
    }

    @Override
    protected void playRound(){
        for(Player player : players){
            System.out.println("It's " + player.getName() + "'s turn, lets see how they do!");
            int playerCurrentLocation = player.getLocation();
            // player performs their playing action (rolling the dice usually)
            int playerNewLocation = playerCurrentLocation + player.play();
            // adjust player's new location for cases of going over the winner tile in Snakes and ladders
            // or looping back to the start for Monopoly
            playerNewLocation = adjustPlayerNewLocation(playerNewLocation, player);
            // get the tile the player will be moving
            TileActionCommand tileCommand = tileActions.get(playerNewLocation);
            // perform that tiles actions with the player
            playerNewLocation = tileCommand.execute(player);
            // update the player and their location
            player.update(playerNewLocation);
            System.out.println();
        }
    }
    private void setup(){
        setupPlainTiles();
        setupGoToTiles();
    }
    @Override
    protected boolean winner()
    {
        int boardSize = tileActions.size();
        boolean winner = false;
        for(Player player : players){
            winner |= player.getLocation() == boardSize;
        }
        return winner;
    }

    @Override
    protected int adjustPlayerNewLocation(int playerNewLocation, Player player) {
        if(playerNewLocation > tileActions.size()){
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
            tileActions.put(location, new PlainTileAction(location));
        }
    }

    private void setupGoToTiles(){
        // Ladder Tiles
        tileActions.put(1, new GoToAction(38));
        tileActions.put(4, new GoToAction(14));
        tileActions.put(9, new GoToAction(31));
        tileActions.put(21, new GoToAction(42));
        tileActions.put(28, new GoToAction(84));
        tileActions.put(36, new GoToAction(44));
        tileActions.put(51, new GoToAction(67));
        tileActions.put(71, new GoToAction(91));
        tileActions.put(80, new GoToAction(100));

        // Snake tiles
        tileActions.put(16, new GoToAction(6));
        tileActions.put(49, new GoToAction(11));
        tileActions.put(48, new GoToAction(26));
        tileActions.put(56, new GoToAction(53));
        tileActions.put(62, new GoToAction(20));
        tileActions.put(64, new GoToAction(60));
        tileActions.put(87, new GoToAction(24));
        tileActions.put(93, new GoToAction(73));
        tileActions.put(95, new GoToAction(75));
        tileActions.put(98, new GoToAction(78));
    }

}
