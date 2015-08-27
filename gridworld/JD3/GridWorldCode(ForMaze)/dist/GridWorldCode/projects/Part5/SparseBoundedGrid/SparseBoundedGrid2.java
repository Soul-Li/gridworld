import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * A <code>BoundedGrid</code> implemented by HashMap(or TreeMap)
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
    private Map<Location, E> occupantMap;
    private int numRows;
    private int numCols;
    /**
     * Constructs an empty unbounded grid.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param numRows number of rows in BoundedGrid
     * @param numCols number of columns in BoundedGrid
     */   
    /**
     * Constructs an empty unbounded grid.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param numRows number of rows in BoundedGrid
     * @param numCols number of columns in BoundedGrid
     */
    /**
     * Constructs an empty unbounded grid.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param numRows number of rows in BoundedGrid
     * @param numCols number of columns in BoundedGrid
     */   
    public SparseBoundedGrid2(int rows, int cols) {
        occupantMap = new HashMap<Location, E>();
        numRows = rows;
        numCols = cols;
    }

    public int getNumRows() {
        return numRows;
    }
        
    public int getNumCols() {
        return numCols;
	}

	public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()  && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet()) {
            a.add(loc);
        }
        return a;
    }

    public E get(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        return occupantMap.get(loc);
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        return occupantMap.put(loc, obj);
    }

    public E remove(Location loc)
    {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        return occupantMap.remove(loc);
    }
}
        
