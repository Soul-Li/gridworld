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
public class MazeBug2 extends MazeBug {
    private int[] dir = new int[4];
	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug2() {
		super();
		for (int i = 0 ; i < 4; i++) {
			dir[i] = 1;
		}
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd) {
		//to show step count when reach the goal
            if (!hasShown) {		
				String msg2 = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg2);
				hasShown = true;
            }
		} else if (willMove) {
			//push the last location to the stack before move to a new location
			Location last2 = getLocation();
			ArrayList<Location> lastLocation2 = new ArrayList<Location>();
			lastLocation2.add(last2);
			crossLocation.push(lastLocation2);
			ArrayList<Location> nextLocation = new ArrayList<Location>();
			nextLocation = getValid(last2);
			if (nextLocation.size() > 1) {
				Random random = new Random();
				int allPart = 0;
				int[] dir2choose = new int[nextLocation.size()];
				for (int i = 0; i < nextLocation.size(); i++) {
					int j = getLocation().getDirectionToward(nextLocation.get(i)) / 90;
					allPart += dir[j];
					dir2choose[i] = dir[j];
				}
				int part = random.nextInt(allPart);
				next = nextLocation.get(chooseDirection(part, dir2choose));
			} else {
				next = nextLocation.get(0);
			}
			dir[getLocation().getDirectionToward(next) / 90]++;
			move();
			//increase step count when move 
			stepCount++;
		} else {
			ArrayList<Location> oldstep = crossLocation.pop();
			next = oldstep.get(0);
			dir[next.getDirectionToward(getLocation()) / 90]--;
			move();
			stepCount++;
		}
	}

	private int chooseDirection(int t, int[] dir2choose) {
		int sum = 0, index = 0;
		for (int i = 0; i < dir2choose.length; i++) {
			if (sum < t && t <= sum+dir2choose[i]) {
				index = i;
				break;
			}
			sum += dir2choose[i];
		}
		return index;
	}

}
