package game_framework.code_base;

public class Player {

    private final String name;
    private int location;
    protected PlayerAction playerAction;

    public Player(String name){
        this.name = name;
        location = 0;
        playerAction = new CanPlay();
    }

    public int getLocation(){
        return location;
    }
    public void update(int location){
        this.location = location;
    }

    public  void setPlayerAction(PlayerAction playerAction){
        this.playerAction = playerAction;
    }
    public String getName(){
        return name;
    }
    public int play(){
        return playerAction.play();
    }

}
