/*Imports*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/*Juggle class will parse the input file and build appropriate objects from it.
  It will also create the output file. */
public class Juggle{
	private Scanner sc;
	private File outputFile;
	private ArrayList<Circuit> circuits = new ArrayList<Circuit>();
	private ArrayList<Juggler> jugglers = new ArrayList<Juggler>();
	private int jugglersPerCircuit;

	/*Juggle constructor will take in the command line argument as a string and create a Scanner out of it.*/
	public Juggle(String input){
		try{
			sc = new Scanner(new File(input));	
		}
		catch(FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage());
		}
	}

	public void parseInput(){
		while(sc.hasNext()){
			if(sc.next().compareTo("C") == 0 ){
				Circuit c = new Circuit(sc.next(), sc.next(), sc.next(), sc.next());
				circuits.add(c);
			}
			else{
				Juggler j = new Juggler(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			 	jugglers.add(j);
			}
		}
		jugglersPerCircuit = jugglers.size() / circuits.size();
		System.out.println("Jugglers per circuit: " + jugglersPerCircuit);
	}	

	public int dotProduct(Circuit c, Juggler j){
		return(
			c.getCoordination() * j.getCoordination() +
			c.getEndurance() * j.getEndurance() + 
			c.getPizzazz() * j.getPizzazz()
			);
	}

	public void 

	public void output(){
		try{
			outputFile = new File("output.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
			output.write("TEST");
			output.close();
		}
		catch(IOException e){
			System.err.println("IOException: " + e.getMessage());
		}
	}
}