package bnp.cib.marsrover.parser;

import org.junit.platform.commons.util.StringUtils;

import bnp.cib.marsrover.model.Location;
import bnp.cib.marsrover.model.Orientation;
import bnp.cib.marsrover.model.Position;
/*
 * Class used to parse intructions.
 */
public class InstructionParser {

	// Method used to init static GridLimitLocation 
    public static Location initGridLimitLocation(String gridLimitLocation) {
    	
    	if(StringUtils.isNotBlank(gridLimitLocation)) {
    		String[] coordinates = gridLimitLocation.split(" ");
    		return new Location(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    	}
    	return null;
    }

    // Method used to parsePosition with controlling positionString
    public static Position parsePosition(String positionString) {
    	
    	if(StringUtils.isNotBlank(positionString)) {
    		int xCoordinate;
    		int yCoordinate;
    		Orientation orientation;
	        String[] positionArray = positionString.split(" ");
	        
	        try {
	        	xCoordinate = Integer.parseInt(positionArray[0]);
		        yCoordinate = Integer.parseInt(positionArray[1]);
		        orientation = Orientation.get(positionArray[2]);
		        
		        return new Position(xCoordinate, yCoordinate, orientation);
		        
	        } catch (final NumberFormatException | IllegalStateException ex) {
		         System.out.print("ERROR: Can't parse position String : "+ ex);
		         System.exit(1);
	        }
    	}
    	return null;
    }
    
}
