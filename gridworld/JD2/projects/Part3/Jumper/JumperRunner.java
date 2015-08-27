import info.gridworld.actor.ActorWorld;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;

public class JumperRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		int num = 10;
		for (int i = 0; i < 10; i++) {
		    world.add(new Jumper());
		    world.add(new Rock());
		    world.add(new Flower());
		    world.add(new Bug());
		}
		world.show();
	}
}
