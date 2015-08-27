import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.Random;
/**
 * This class runs a world that contains Dancing bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner {
	public static void main(String[] args) {
                Random random = new Random();
                int move[] = new int[20];
                for (int i = 0; i < 20; i++) {
                     move[i] = Math.abs(random.nextInt()*10 % 10);
                }
		ActorWorld world = new ActorWorld();
		DancingBug db = new DancingBug(move);
		db.setColor(Color.CYAN);
		world.add(new Location(5,5), db);
		world.show();
	}
}
