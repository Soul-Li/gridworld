package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = new Location(0, 0);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd) {
		//to show step count when reach the goal		
			if (!hasShown) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			//push the last location to the stack before move to a new location
			last = getLocation();
			ArrayList<Location> lastLocation = new ArrayList<Location>();
			lastLocation.add(last);
			crossLocation.push(lastLocation);
			ArrayList<Location> nextLocation = new ArrayList<Location>();
			nextLocation = getValid(last);
			if (nextLocation.size() > 1) {
				Random random = new Random();
				int temp = random.nextInt(nextLocation.size());
				next = nextLocation.get(temp);
			} else {
				next = nextLocation.get(0);
			}
			move();
			//increase step count when move 
			stepCount++;
		} else {
			ArrayList<Location> oldstep = crossLocation.pop();
			next = oldstep.get(0);
			move();
			stepCount++;
		}
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return null;
        }
		ArrayList<Location> valid = new ArrayList<Location>();
		
		for (int i = 0; i < 4; i++) {
			Location validLoc = loc.getAdjacentLocation(i * Location.RIGHT);
			if (gr.isValid(validLoc)) {
				if ((gr.get(validLoc) instanceof Rock) && gr.get(validLoc).getColor().getRed() == Color.RED.getRed()) {
					isEnd = true;
					valid.add(validLoc);
					break;
				} else if (gr.get(validLoc) == null) {
					valid.add(validLoc);
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> nextstep = getValid(getLocation());
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return false;
		}
		if (nextstep.size() == 0) {
			//need to return to last location
			return false;           
		} else {
			//move to a new location
			return true;
		}
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return;
        }
		Location loc = getLocation();
		if (gr.isValid(next)) {
			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		} else {
			removeSelfFromGrid();
        }
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
