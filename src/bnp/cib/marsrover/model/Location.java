package bnp.cib.marsrover.model;

import java.util.Objects;
/*
 * Class used to represent a location defined by x and y 
 */
public class Location {
    
	// Attributes
	private int x;
    private int y;

    // getters
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// constractor
	public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * Check if the this location is inside the grid limit of (xLimit,yLimit)
     */
    public boolean isWithIn(int xLimit, int yLimit) {
        return this.x <= xLimit && this.y <= yLimit;
    }
    /*
     * Check if the this location is not out of the grid limit of (xLimit,yLimit)
     */
    public boolean isNotOutside(int xLimit, int yLimit) {
        return this.x >= xLimit && this.y >= yLimit;
    }
    
    /*
     * Check if the new location is a valid move or not
     */
    public boolean isValidMove(Location newLocation) {
        return newLocation.isWithIn(x, y) && newLocation.isNotOutside(0, 0);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
