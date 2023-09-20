package bnp.cib.marsrover.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrientationTest {

    @Test
    public void shouldReturnLeft() {
        assertEquals(Orientation.EAST, Orientation.SOUTH.left());
        assertEquals(Orientation.WEST, Orientation.NORTH.left());
    }

    @Test
    public void shouldReturnRight() {
        assertEquals(Orientation.WEST, Orientation.SOUTH.right());
        assertEquals(Orientation.EAST, Orientation.NORTH.right());
    }

    @Test
    public void shouldReturnDirectionAlphabet() {
        assertEquals("E", Orientation.EAST.toString());
        assertEquals("W", Orientation.WEST.toString());
    }
}