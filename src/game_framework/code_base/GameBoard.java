package game_framework.code_base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameBoard {
    private Map<Integer, BoardActionCommand> boardActions;
    List<Player> players;

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

    public final void playRound(){
        for(Player player : players){
            System.out.println("It's " + player.getName() + "'s turn, lets see how they do!");
            int playerCurrentLocation = player.getLocation();
            // player performs their playing action (rolling the dice usually)
            int playerNewLocation = playerCurrentLocation + player.play();
            // get the tile the player will be moving
            BoardActionCommand tileCommand = boardActions.get(playerNewLocation);
            // perform that tiles actions with the player
            tileCommand.execute(player);
            // update the player and their location
            player.update(playerNewLocation);

            System.out.println();
        }
    }
}
