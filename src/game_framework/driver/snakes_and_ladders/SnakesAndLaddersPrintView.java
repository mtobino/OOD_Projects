package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.GameView;
import game_framework.code_base.Player;

public class SnakesAndLaddersPrintView implements GameView {
    @Override
    public void updateView(Object gameData) {
        String update = (String) gameData;
        System.out.println(update);
    }

    @Override
    public void showcasePlayer(Player player) {
        System.out.println("It's " + player.getName() + "'s turn, lets see how they do!\n" +
                "They are starting this turn at tile " + player.getLocation());
    }

    @Override
    public void deselectPlayer(Player player) {
        System.out.println(player.getName() + "'s turn has ended.");

    }

    @Override
    public void updatePlayerView(Player player, int startingLocation) {
        if(startingLocation == player.getLocation()){
            System.out.println(player.getName() + " did not move this turn");
        }
        else{
            System.out.println(player.getName() + " started at position " + startingLocation +
                    " and now is at " + player.getLocation());
        }


    }

    @Override
    public void showPlayerRoll(Player player, int roll) {
        System.out.println(player.getName() + " spun a " + roll);
    }

    @Override
    public void displayEnd(Object endResults) {
        String end = (String) endResults;
        System.out.println(end);

    }
}
