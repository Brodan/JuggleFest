/*
	This program is my attempt to solve Yodle's
	"Juggle Fest" coding challenge as part of the
	"Yodle Juggler Raffle".
	Date: 8/20/16
	Author: Christopher Hranj
*/

/*Imports*/
import java.io.File;

/*
Yodle class will act as a driver.
*/
public class Yodle{
	public static void main(String[] args){
		/*One command line argument should be passed. 
		This argument will be the name of the input file that contains the jugglers and circuits.*/
		if (args.length == 0) {
            System.out.println("No file was given. Exiting...");
            System.exit(0);
        }
        else {
        	/*Pass the argument file into a Juggle object.*/
            Juggle juggle = new Juggle(args[0]);
            juggle.parseInput();
            juggle.match();
            juggle.writeOutput();
            juggle.printEmailAddress();
        }
		
		/*Exit program successfully.*/
		System.out.println("Program exiting...");
		System.exit(0);
	}
}
