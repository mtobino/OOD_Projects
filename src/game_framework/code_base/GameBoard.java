package game_framework.code_base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameBoard {
    protected Map<Integer, BoardActionCommand> boardActions;
    protected List<Player> players;

    public GameBoard(){
        boardActions = new HashMap<>();
        players = new ArrayList<>();
    }

    public Map<Integer, BoardActionCommand> getBoardActions() {
        return boardActions;
    }

    public void registerPlayer(Player player)
    {
        players.add(player);
    }

    public void removePlayer(Player player){
        players.removeIf(player1 -> player1.equals(player));
    }

    public void addGameTiles(int location, BoardActionCommand boardAction){
        boardActions.put(location, boardAction);
    }

    public void playRound(){
        for(Player player : players){
            System.out.println("It's " + player.getName() + "'s turn, lets see how they do!");
            int playerCurrentLocation = player.getLocation();
            // player performs their playing action (rolling the dice usually)
            int playerNewLocation = playerCurrentLocation + player.play();
            // adjust player's new location for cases of going over the winner tile in Snakes and ladders
            // or looping back to the start for Monopoly
            playerNewLocation = adjustPlayerNewLocation(playerNewLocation, player);
            // get the tile the player will be moving
            BoardActionCommand tileCommand = boardActions.get(playerNewLocation);
            // perform that tiles actions with the player
            playerNewLocation = tileCommand.execute(player);
            // update the player and their location
            player.update(playerNewLocation);
            System.out.println();
        }
    }

    public void play(){
        while(!winner())
        {
            playRound();
        }
    }

    protected abstract boolean winner();

    protected abstract int adjustPlayerNewLocation(int playerNewLocation, Player player);

}
