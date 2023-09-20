package bnp.cib.marsrover.model;

import static bnp.cib.marsrover.model.Orientation.EAST;
import static bnp.cib.marsrover.model.Orientation.NORTH;
import static bnp.cib.marsrover.model.Orientation.SOUTH;
import static bnp.cib.marsrover.model.Orientation.WEST;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PositionTest {
    private Position positionNorth;
    private Position positionEast;

    @Before
    public void initPositions() {
        positionNorth = new Position(0,0, NORTH);
        positionEast = new Position(0,0, EAST);
    }

    @Test
    public void shouldTurnRight() {
        assertEquals(new Position(0,0, EAST), positionNorth.rotateRight());
        assertEquals(new Position(0,0, SOUTH), positionEast.rotateRight());
    }

    @Test
    public void shouldTurnLeft() {
        assertEquals(new Position(0,0, WEST), positionNorth.rotateLeft());
        assertEquals(new Position(0,0, NORTH), positionEast.rotateLeft());
    }

    @Test
    public void shouldMoveAhead() {
        assertEquals(new Position(0,1, NORTH), positionNorth.moveAhead());
        assertEquals(new Position(1,0, EAST), positionEast.moveAhead());
    }
}
