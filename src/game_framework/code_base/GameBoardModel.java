package game_framework.code_base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameBoardModel {
    protected Map<Integer, TileActionCommand> tileActions;

    public List<Player> getPlayers() {
        return players;
    }

    protected List<Player> players;

    /**
     * Constructor for generic game board
     */
    public GameBoardModel(){
        tileActions = new HashMap<>();
        players = new ArrayList<>();
    }

    /**
     * Getter for the Tile Actions Map
     *
     * @return The map of the board actions where the key is the tile locations and the value the tile's command
     */
    public Map<Integer, TileActionCommand> getTileActions() {
        return tileActions;
    }

    /**
     * Register a player to observe the game board
     *
     * @param player the player of the game
     */
    public void registerPlayer(Player player)
    {
        players.add(player);
    }

    /**
     * Remove a player from the game
     *
     * @param player the player being removed from the game
     */
    public void removePlayer(Player player){
        players.removeIf(player1 -> player1.equals(player));
    }

    /**
     * Remove a player from the game by name
     *
     * @param name  The name of the player being removed
     */
    public void removePlayerByName(String name){
        players.removeIf(player -> player.getName().equals(name));
    }

    /**
     * Play a round of the game, subclasses determine how a round is played
     *
     * @return obj  A generic stand in for a game data object that could contain more information for a view to use
     */
    public abstract Object playRound(Player player, int roll);

    /*
     * Play the game until it is won by someone. Once it is won, display the final results of the game
     * If you have not added enough players, it will quit out before running the program.
     *
//    public final void play(){
//        if(!verifyPartySize()){
//            System.out.println("Your player count is off!\nCheck your rule book to see how many players you need" +
//                    "or are allowed to have.");
//            return;
//        }
//        setup();
//        while(!winner())
//        {
//            playRound();
//        }
//        displayResults();
//    }
*/
    /**
     * Verify the party size of the game
     *
     * @return  true iff the partu size is the correct size
     */
    public abstract boolean verifyPartySize();

    public abstract void setup();

    /**
     * Display the final results of the game. Subclasses determine how a player is displayed
     *
     * @return result   The end result of the game, could be a game data object
     */
    public abstract Object getEndResults();

    /**
     * Returns true iff someone has won the game, otherwise it will be false
     *
     * @return true iff some player won the game.
     */
    public abstract boolean winner();

    /**
     * Adjust the player's new position based on the board and how it functions
     * In Snakes and Ladders you cannot go over the winning tile
     * In Monopoly you will loop around the board
     *
     * @param playerNewLocation the new player location that has to be checked
     * @param player            if the player cannot move, we have to take their location into account
     * @return                  the adjusted location
     */
    protected abstract int adjustPlayerNewLocation(int playerNewLocation, Player player);

}
