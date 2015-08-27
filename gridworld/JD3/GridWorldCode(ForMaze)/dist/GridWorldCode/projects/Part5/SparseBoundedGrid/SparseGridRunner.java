import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
/**
 * This class runs a world that contains three types of new world. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SparseGridRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.addGridClass("SparseBoundedGrid");
		world.addGridClass("SparseBoundedGrid2");
		//world.addGridClass("SparseBounderGrid3");
		world.addGridClass("UnboundedGrid2");
	        world.add(new Location(2, 2), new Critter());
		world.show();
	}
}
