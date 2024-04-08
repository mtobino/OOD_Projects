package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.TileActionCommand;
import game_framework.code_base.Player;

import java.util.Objects;

public class PlainTileAction implements TileActionCommand {
    private final int tileLocation;

    public PlainTileAction(int tileLocation) {
        this.tileLocation = tileLocation;
    }

    @Override
    public int execute(Player player) {
        return tileLocation;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PlainTileAction that = (PlainTileAction) object;
        return tileLocation == that.tileLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tileLocation);
    }
}
