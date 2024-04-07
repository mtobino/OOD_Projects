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
            int playerCurrentLocation = player.getLocation();
            int playerNewLocation = playerCurrentLocation + player.play();

            BoardActionCommand tileCommand = boardActions.get(playerNewLocation);
            tileCommand.execute(player);

        }
    }
}
