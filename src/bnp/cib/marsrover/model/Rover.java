package bnp.cib.marsrover.model;

import java.util.SplittableRandom;

/*
 * Class representing a Rover
 * A rover have a name and a position. it can moveAhead, turnLeft and turnRight.
 *  
 */
public class Rover {
    
	// attributs
	private String name;
	private Position position;

	private static Location gridLimitLocation;

	// constructors
    public Rover(Position position) {
    	this.name= "MARS-ROVER-" + new SplittableRandom().nextInt(0, 1_001);
        this.position = position;
    }

    // getters name and position
    public String getName() {
		return name;
	}

	public Position getPosition() {
        return position;
    }
	
	public static Location getGridLimitLocation(Location gridLimitLocation) {
		if(Rover.gridLimitLocation == null) {
			Rover.gridLimitLocation = gridLimitLocation;
		}
		return Rover.gridLimitLocation;
	}
	public static Location getGridLimitLocation() {
		return gridLimitLocation;
	}

	// public method process used to execute many instructions
    public void process(String instructions) {
        instructions.chars().mapToObj( c -> (char) c).forEach(this::process);
    }

    // private method process used to execute 1 instruction
    private void process(Character instruction) {
        switch (instruction) {
            case 'R':
                turnRight();
                break;
            case 'L':
                turnLeft();
                break;
            case 'M':
                move();
                break;
        }
    }

    // Method used to move Ahead on once the new move is valid
    private void move() {
        if(gridLimitLocation.isValidMove(position.moveAhead().getLocation())) {
            position = position.moveAhead();
        }
    }

    // Method used to turn left
    private void turnLeft() {
        position = position.rotateLeft();
    }

    // Method used to turn righ
    private void turnRight() {
        position = position.rotateRight();
    }

	@Override
	public String toString() {
		return "Rover [name=" + name + ", position=" + position.toString() + "]";
	}
}
