package bnp.cib.marsrover.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LocationTest {
    private Location location;

    @Before
    public void setupGrid() {
    	location = new Location(5, 5);
    }

    @Test
    public void shouldReturnTrueIfAMoveIsValid() {
    	Location newLocation = new Location(1, 2);
        assertTrue(location.isValidMove(newLocation));
    }

    @Test
    public void shouldReturnFalseIfAMoveIsInvalid() {
    	Location newLocation1 = new Location(1, 6);
    	Location newLocation2 = new Location(-1, -6);

        assertFalse(location.isValidMove(newLocation1));
        assertFalse(location.isValidMove(newLocation2));
    }
    
    @Test
    public void shouldReturnTrueWhenLocationIsInsideGivenCoordinates() {
    	Location location = new Location(1, 2);
        assertTrue(location.isWithIn(5, 5));
    }

    @Test
    public void shouldReturnFalseWhenLocationIsNotInsideGivenCoordinates() {
    	Location location = new Location(6, 2);
        assertFalse(location.isWithIn(5, 5));
    }
     @Test
    public void shouldReturnTrueWhenLocationIsNotOutsideGivenCoordinates() {
    	Location location = new Location(1, 2);
        assertTrue(location.isNotOutside(0, 0));
    }

    @Test
    public void shouldReturnFalseWhenLocationIsOutsideGivenCoordinates() {
    	Location location = new Location(-1, 2);
        assertFalse(location.isNotOutside(0, 0));
    }
}
