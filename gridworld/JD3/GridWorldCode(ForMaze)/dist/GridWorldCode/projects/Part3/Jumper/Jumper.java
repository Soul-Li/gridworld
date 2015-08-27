import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor {
	public Jumper() {
		setColor(Color.RED);
	}

	public Jumper(Color jumperColor) {
		setColor(jumperColor);
	}
	public void act() {
		if (canMove()) {
			move();
		}
		else
		{
            turn();
		}
	}

	public void turn() {
		setDirection(getDirection() + Location.HALF_RIGHT);
	}

	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
		}
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location twoMove = next.getAdjacentLocation(getDirection());
		moveTo(twoMove);
	}

	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next)) {
			return false;
		}
		Actor onestep = gr.get(next);
		if (onestep != null && !((onestep instanceof Flower) || (onestep instanceof Rock))) {
			return false;
		}
		Location twoMove = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(twoMove)) {
			return false;
		}
		else
		{
			return (gr.get(twoMove) == null || gr.get(twoMove) instanceof Flower);
		}
	}
}


