import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A BlusterCritter looks at all of the neighbors within two steps of its current location.
 * If there are fewer than c critters, the BlusterCritter's color gets brighter (color values increase).
 * If there are c or more critters, the BlusterCritter's color darkens (color values decrease).
 */
public class BlusterCritter extends Critter {
    private int courage;
    private static final int CHANGING_FACTOR = 15;
    public BlusterCritter(int c) {
        setColor(Color.RED);
        courage = c;
    }

    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        for (int row = loc.getRow() - 2; row <= loc.getRow() + 2; row++) {
            for (int col = loc.getCol() - 2; col <= loc.getCol() + 2; col++) {
                Location l = new Location(row, col);
                if (getGrid().isValid(l)) {
                    Actor actor = getGrid().get(l);
                    if (actor != null && actor != this) {
                        actors.add(actor);
                    }
                }
            }
        }
        return actors;
    }
	public void processActors(ArrayList<Actor> actors) {
        int count = 0;
        for (Actor a: actors) {
            if (a instanceof Critter) {
                count++;
            }
        }
        Color c = getColor();
        int red = c.getRed(), green = c.getGreen(), blue = c.getBlue();
        if (count < courage) {
            red = (red > 0 ? red - CHANGING_FACTOR: red);
            green = (green > 0 ? green - CHANGING_FACTOR: green);
            blue = (blue > 0 ? blue - CHANGING_FACTOR: blue);
        }
        else
        {    
            red = (red > 0 ? red + CHANGING_FACTOR: red);
            green = (green > 0 ? green + CHANGING_FACTOR: green);
            blue = (blue > 0 ? blue + CHANGING_FACTOR: blue);
        }
        setColor(new Color(red, green, blue));
        return;
    }
}
