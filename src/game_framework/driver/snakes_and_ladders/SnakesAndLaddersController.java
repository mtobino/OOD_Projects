package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameBoardModel;
import game_framework.code_base.GameController;
import game_framework.code_base.GameView;
import game_framework.code_base.Player;

public class SnakesAndLaddersController extends GameController {
    public SnakesAndLaddersController(GameBoardModel boardModel, GameView gameView) {
        super(boardModel, gameView);
    }

    @Override
    public void play() {
        if(!boardModel.verifyPartySize()) {
            gameView.updateView("Your player count is off!\nCheck your rule book to see how " +
                    "many players you need or are allowed to have.");
            return;
        }
        boardModel.setup();
        while(!boardModel.winner()){
            for(Player player : boardModel.getPlayers()){
                int startingLocation = player.getLocation();
                gameView.showcasePlayer(player);
                int playerRoll = player.play();
                gameView.showPlayerRoll(player, playerRoll);
                boardModel.playRound(player, playerRoll);
                gameView.updatePlayerView(player, startingLocation);
                gameView.deselectPlayer(player);
                gameView.updateView("\n");
            }
        }
        Object endResults = boardModel.getEndResults();
        gameView.displayEnd(endResults);
    }

}
