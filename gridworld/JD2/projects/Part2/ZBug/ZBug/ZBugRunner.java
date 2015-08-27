import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
/**
 * This class runs a world that contains Z bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class ZBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		ZBug zb1 = new ZBug(4);
		zb1.setColor(Color.BLUE);
		ZBug zb2 = new ZBug(9);
                zb2.setColor(Color.LIGHT_GRAY);
		world.add(new Location(7,7), zb1);
		world.add(new Location(0,0), zb2);
		world.show();
	}
}
