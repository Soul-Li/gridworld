import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
/**
 * This class runs a world that contains Circle bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CircleBugRunner {
    public static void main(String[] args) {
	ActorWorld world = new ActorWorld();
	CircleBug ly = new CircleBug(3);
	ly.setColor(Color.ORANGE);
	CircleBug hqk = new CircleBug(5);
        world.add(new Location(3,4), ly);
	world.add(new Location(4,5), hqk);
	world.show();
    }
}
