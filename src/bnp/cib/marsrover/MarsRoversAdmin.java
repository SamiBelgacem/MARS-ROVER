package bnp.cib.marsrover;

import static bnp.cib.marsrover.parser.InstructionParser.initGridLimitLocation;
import static bnp.cib.marsrover.parser.InstructionParser.parsePosition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bnp.cib.marsrover.model.Rover;
/*
 * Main Class used manage Rovers and execute instructions.
 */
public class MarsRoversAdmin {
    
	private static final String INPUT_FILENAME = "input.txt";
	private static Scanner scanner;

	public static void main(String[] args) {

	    try {
	    	
		    if(args.length == 0){
		    	System.out.println("INFO : File name as the first commandline argument is empty !");
		    	scanner = new Scanner(new File(INPUT_FILENAME));
		    }else {
		    	System.out.println("INFO : File name as the first commandline argument :" + args[0]);
		    	scanner = new Scanner(new File(args[0]));
		    }
	
	    }catch (final FileNotFoundException exception) {
	         System.out.print("ERROR: File not found");
	         System.exit(1);
	    }
	    
	    if(scanner != null) {
	    	
	    	// Extract the upper right coordinates of the grid from the first line of input used to init grid limit location
		    // The gridLimitLocation is used in static mode and will be shared by all instances of Rover.class
	    	Rover.setGridLimitLocation(initGridLimitLocation(scanner.nextLine()));
			
	  		// List of rovers
			List<Rover> rovers = new ArrayList<Rover>();
			
	    	while(scanner.hasNext()) {
	    		// create new Rover and then process instructions
	    		Rover rover = new Rover(parsePosition(scanner.nextLine()));
	    		rovers.add(rover);
	    		rover.process(scanner.nextLine());
	    	}
	    	// print rovers informations
	    	rovers.forEach(r -> System.out.println(r.toString()));
	    	
	    	// close scanner once all instructions are readed and executed
	    	scanner.close();
	    }
	}
}
