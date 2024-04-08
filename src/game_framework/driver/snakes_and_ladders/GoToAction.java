package game_framework.driver.snakes_and_ladders;

import game_framework.code_base.TileActionCommand;
import game_framework.code_base.Player;

import java.util.Objects;

public class GoToAction implements TileActionCommand {
    private final int GoToLocation;

    public GoToAction(int goToLocation) {
        GoToLocation = goToLocation;
    }

    @Override
    public int execute(Player player) {
        return GoToLocation;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GoToAction that = (GoToAction) object;
        return GoToLocation == that.GoToLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(GoToLocation);
    }
}
