import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{
    public QuickCrab()
    {
        setColor(Color.CYAN);
    }

/**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Location loc = getLocation();
        Location lloc = loc.getAdjacentLocation(getDirection() + Location.LEFT);
        Location rloc = loc.getAdjacentLocation(getDirection() + Location.RIGHT);
        if (getGrid().isValid(lloc) && getGrid().get(lloc) == null) {
            Location llloc = lloc.getAdjacentLocation(getDirection() + Location.LEFT);
            if (getGrid().isValid(llloc) && getGrid().get(llloc) == null) {
                locs.add(llloc);
            }
        }
        if (getGrid().isValid(rloc) && getGrid().get(rloc) == null) {
            Location rrloc = rloc.getAdjacentLocation(getDirection() + Location.RIGHT);
            if (getGrid().isValid(rrloc) && getGrid().get(rrloc) == null) {
                locs.add(rrloc);
            }
        }
        return (locs.size() > 0 ? locs : super.getMoveLocations());
    }
}


