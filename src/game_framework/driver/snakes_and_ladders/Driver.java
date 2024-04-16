package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameController;
import game_framework.code_base.Player;

public class Driver {
    public static void main(String[] args){
        GameController gameBoard = new SnakesAndLaddersController(new SnakesAndLaddersBoard()
                , new SnakesAndLaddersPrintView());
        gameBoard.registerPlayer(new Player("Danielle", new SpinnerWheelAction()));
        gameBoard.registerPlayer(new Player("Matt", new SpinnerWheelAction()));
        gameBoard.registerPlayer(new Player("Jason", new SpinnerWheelAction()));
        gameBoard.registerPlayer(new Player("Riley", new SpinnerWheelAction()));
        gameBoard.registerPlayer(new Player("Noah", new SpinnerWheelAction()));
        gameBoard.play();
        gameBoard.removePlayerByName("Noah");
        gameBoard.play();


    }

}
