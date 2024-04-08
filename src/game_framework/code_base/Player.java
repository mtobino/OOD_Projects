package game_framework.code_base;

public abstract class Player {

    private final String name;
    private int location;
    protected PlayerAction playerAction;

    public Player(String name){
        this(name, new CanPlay());
    }

    public Player(String name, PlayerAction playerAction){
        this.name = name;
        location = 0;
        this.playerAction = playerAction;
    }

    public int getLocation(){
        return location;
    }
    public void update(int location){
        if(location == this.location){
            System.out.println("Player did not move.");
        }
        else{
            System.out.println("Player moved to tile " + location);
            this.location = location;
        }
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
