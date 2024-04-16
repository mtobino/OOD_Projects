package game_framework.code_base;

/**
 * An Abstract Game Controller class to control the game and dictate its actions
 *
 * @author Matthew Tobino
 */
public abstract class GameController {
    protected final GameBoardModel boardModel;
    protected final GameView gameView;


    /**
     * Constructor for the Game Controller
     *
     * @param boardModel    The game board model that will handle most of the game actions
     * @param gameView      The game view that will display the results from the game board
     */
    public GameController(GameBoardModel boardModel, GameView gameView) {
        this.boardModel = boardModel;
        this.gameView = gameView;
    }

    /**
     * Register a player to the game
     *
     * @param player    the player being registered
     */
    public void registerPlayer(Player player){
        boardModel.registerPlayer(player);
    }

    /**
     * Remove a player from the game
     *
     * @param player    the player being removed
     */
    public void removePlayer(Player player){
        boardModel.removePlayer(player);
    }

    /**
     * Remove a player from the game by their name
     *
     * @param name  the name of the player being removed from the game
     */
    public void removePlayerByName(String name){
        boardModel.removePlayerByName(name);
    }

    /**
     * Hard to say each game will function the same when played so this method was abstracted
     */
    public abstract void play();
}
