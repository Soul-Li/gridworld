import info.gridworld.grid.*;

import java.util.ArrayList;
import java.util.*;

/**
 * An <code>UnboundedGrid</code> is a rectangular grid with an unbounded number of rows and
 * columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E> {
    //implement an two-dimensional array instead of a hashMap
	private Object[][] occupantMap;
	private int size;
    /**
     * Constructs an empty unbounded grid.
     */
	public UnboundedGrid2() {
		size = 16;
		occupantMap = new Object[size][size];
	}

	public int getNumRows() {
		return -1;
	}

	public int getNumCols() {
		return -1;
	}
    //all valid locations have non-negative row and column values
	public boolean isValid(Location loc) {
		return (loc.getRow() >= 0 && loc.getCol() >= 0);
	}

	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> a = new ArrayList<Location>();

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				Location loc = new Location(r,c);
				if (get(loc) != null) {
					a.add(loc);
				}
			}
		}
        return a;
	}

    public E get(Location loc) {
		if (!isValid(loc)) {
			throw new IllegalArgumentException("Location " + loc + " is not valid");
		}
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
		if (loc.getRow() >= size || loc.getCol() >= size) {
			return null;
		}
		return (E)occupantMap[loc.getRow()][loc.getCol()];
	}

	public E put(Location loc, E obj) {
		if (loc == null) {
			throw new NullPointerException("loc == null");
		}
		if (obj == null) {
			throw new NullPointerException("obj == null");
		}
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
    /**When a call is made to the put method with a row 
     * or column index that is outside the current array bounds
     * double both array bounds until they are large enough,
     */
		if (loc.getRow() >= size || loc.getCol() >= size) {
			resize(loc);
		}
        E oldOccupant = get(loc);
		occupantMap[loc.getRow()][loc.getCol()] = obj;
		return oldOccupant;
	}

	public E remove(Location loc) {
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (loc.getRow() >= size || loc.getCol() >= size) {
			return null;
		}
        E r = get(loc);
        occupantMap[loc.getRow()][loc.getCol()] = null;
        return r;
	}
    //resize the occupanArray
    private void resize(Location loc) {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        int oldsize = size;
        while (loc.getRow() >= size || loc.getCol() >= size) {
            size *= 2;
        }
        Object[][] temp = new Object[size][size];
        for (int r = 0; r < oldsize; r++) {
            for (int c = 0; c < oldsize; c++) {
                temp[r][c] = occupantMap[r][c];
            }
        }
        occupantMap = temp;
    }
}
