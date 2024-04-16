package game_framework.code_base;

/**
 * A View Interface to facilitate how each view might handle information
 *
 * @author Matthew Tobino
 */
public interface GameView {
    /**
     * A generic update to the game view with some game data
     *
     * @param gameData  the game data that is being sent to the view
     */
    void updateView(Object gameData);

    /**
     * Showcase the player, in GUIs this could highlight a player
     *
     * @param player    the player being showcased
     */
    void showcasePlayer(Player player);

    /**
     * Stop showcasing the player, or declare that their turn has ended
     *
     * @param player    the player whose turn finished
     */
    void deselectPlayer(Player player);

    /**
     * Update the player's view in some manner
     *
     * @param player            the player whose view is being updated
     * @param startingLocation  the starting location of that player
     */
    void updatePlayerView(Player player, int startingLocation);

    /**
     * Show the player's roll, in GUI's this could be a die/spinner animation
     *
     * @param player    the player who is making a move
     * @param roll      the roll the player made
     */
    void showPlayerRoll(Player player, int roll);

    /**
     * Display the end results of the game
     *
     * @param endResults    the game data object that contains all the information about the end of the game
     */
    void displayEnd(Object endResults);
}
