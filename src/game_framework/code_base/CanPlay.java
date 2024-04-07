package game_framework.code_base;

import java.util.Random;

public class CanPlay extends PlayerAction{
    private static final Random rand = new Random();

    /**
     * Player can play the game, and they roll two dice
     *
     * @return player's roll between 2 and 12 inclusive.
     */
    public int play(){
        return rand.nextInt(2, 13);
    }

}
