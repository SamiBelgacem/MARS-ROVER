package bnp.cib.marsrover.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    
	Rover rover;
	Location gridLimitLocation;

    @Before
    public void setUp() {
        Rover.setGridLimitLocation(new Location(5,5));
        rover = new Rover(new Position(1, 2, Orientation.NORTH));
    }

    @Test
    public void shouldTurnRight() {
        rover.process("R");
        assertEquals(new Position(1, 2, Orientation.EAST), rover.getPosition());
    }

    @Test
    public void shouldTurnLeft() {
        rover.process("L");
        assertEquals(new Position(1, 2, Orientation.WEST), rover.getPosition());
    }

    @Test
    public void shouldMoveForward() {
        rover.process("M");
        assertEquals(new Position(1, 3, Orientation.NORTH), rover.getPosition());
    }

    @Test
    public void shouldFollowMultipleInstructions() {
        rover.process("RLM");
        assertEquals(new Position(1, 3, Orientation.NORTH), rover.getPosition());
    }

    @Test
    public void shouldNotMoveForwardForAnInvalidMove() {
        rover.process("MMMLMRMM");
        assertEquals(new Position(0, 5, Orientation.NORTH), rover.getPosition());
    }
}
