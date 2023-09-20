package bnp.cib.marsrover.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bnp.cib.marsrover.model.Orientation;
import bnp.cib.marsrover.model.Location;
import bnp.cib.marsrover.model.Position;

public class InstructionParserTest {

    @Test
    public void testInitGrid() {
        String instruction = "5 5";
        assertEquals(new Location(5, 5), InstructionParser.initGridLimitLocation(instruction));
    }

    @Test
    public void testParsePosition() {
        String instruction = "1 2 N";
        assertEquals(new Position(1, 2, Orientation.NORTH), InstructionParser.parsePosition(instruction));
    }
}