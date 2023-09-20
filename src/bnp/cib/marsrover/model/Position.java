package bnp.cib.marsrover.model;

import java.util.Objects;
/*
 * Class representing a position. A position is defined by a location and an orientation.
 */
public class Position {
    
	//Atrributes
	private Location location;
    private Orientation orientation;

    // Constractors
    public Position(int x, int y, Orientation direction) {
        this.location = new Location(x,y);
        this.orientation = direction;
    }

    public Position(Location location, Orientation direction) {
        this.location = location;
        this.orientation = direction;
    }
    
    // Getters
    public Location getLocation() {
		return location;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	// Method used to rotateRight
	public Position rotateRight() {
        return new Position(location.getX(), location.getY(), orientation.right());
    }

	// Method Used to rotateLeft
    public Position rotateLeft() {
        return new Position(location.getX(), location.getY(), orientation.left());
    }

    // Method used to moveAhead
    public Position moveAhead() {
        switch (orientation.toString()) {
            case "E":
                return new Position(location.getX()+1, location.getY(), orientation);
            case "W":
                return new Position(location.getX()-1, location.getY(), orientation);
            case "N":
                return new Position(location.getX(), location.getY()+1, orientation);
            case "S":
                return new Position(location.getX(), location.getY()-1, orientation);
            default:
                throw new IllegalStateException("Unknown Orientation");
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(location, orientation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Objects.equals(location, other.location) && orientation == other.orientation;
	}

	@Override
	public String toString() {
		return "Position [location=( " + location.getX() + "," + location.getY() + " ), orientation= " + orientation + "]";
	}  
}
