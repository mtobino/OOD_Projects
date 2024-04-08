package game_framework.code_base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GameBoard {
    protected Map<Integer, TileActionCommand> tileActions;
    protected List<Player> players;

    /**
     * Constructor for generic game board
     */
    public GameBoard(){
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

    public void removePlayerByName(String name){
        players.removeIf(player -> player.getName().equals(name));
    }

    /**
     * Play a round of the game, subclasses determine how a round is played
     */
    protected abstract void playRound();

    /**
     * Play the game until it is won by someone. Once it is won, display the final results of the game
     * If you have not added enough players, it will quit out before running the program.
     */
    public final void play(){
        if(players.size() < 2){
            System.out.println("You need at least 2 people to play a game silly :P");
            return;
        }
        else if(players.size() > 4){
            System.out.println("Too many cooks spoil the broth! Consider playing with no more than 4 people.");
            return;
        }
        while(!winner())
        {
            playRound();
        }
        displayResults();
    }

    /**
     * Display the final results of the game. Subclasses determine how a player is displayed
     */
    protected abstract void displayResults();

    /**
     * Returns true iff someone has won the game, otherwise it will be false
     *
     * @return true iff some player won the game.
     */
    protected abstract boolean winner();

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
