import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RockHoundRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        int num = 30;
        for (int i = 0; i < num; i++) {
            world.add(new Rock());
        }
        world.add(new RockHound());
        world.show();
    }
}
