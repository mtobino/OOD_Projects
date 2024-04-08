package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameBoard;
import game_framework.code_base.Player;

public class Driver {
    public static void main(String[] args){
        GameBoard gameBoard = new SnakesAndLaddersBoard();
        gameBoard.registerPlayer(new Player("Danielle", new SpinnerWheelAction()));
        gameBoard.registerPlayer(new Player("Matt", new SpinnerWheelAction()));
        gameBoard.play();
    }

}
