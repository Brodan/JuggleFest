/*Imports*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

/*Juggle class will parse the input file and build appropriate objects from it.
  It will also create the output file. */
public class Juggle{
	private Scanner sc;
	private File outputFile;
	//private Map<String, Circuit> circuits = new LinkedHashMap<String, Circuit>();
	//private Map<String, Juggler> jugglers = new LinkedHashMap<String, Juggler>();
	private ArrayList<Juggler> jugglers = new ArrayList<Juggler>();
	private ArrayList<Circuit> circuits = new ArrayList<Circuit>();
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
				String name = sc.next();
				int h = Integer.parseInt(sc.next().substring(2));
				int e = Integer.parseInt(sc.next().substring(2));
				int p = Integer.parseInt(sc.next().substring(2));
				String circuitPreferances = sc.next();
				//ArrayList of Pairs
				//ArrayList<Map<String, Integer>> prefs = new ArrayList<Map<String, Integer>>();
				Map<String, Integer> prefs = new LinkedHashMap<String, Integer>();

				for(String preferance : circuitPreferances.split("[,]")){
					int circuitNum = Integer.parseInt(preferance.substring(1));
					// Calculate dot product
					int dotProduct = h * circuits.get(circuitNum).getCoordination() +
									 e * circuits.get(circuitNum).getEndurance() +
									 p * circuits.get(circuitNum).getPizzazz();
					prefs.put(preferance, dotProduct);
				}
				//Juggler j = new Juggler(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			 	Juggler j = new Juggler(name, prefs);
			 	jugglers.add(j);
			}
		}
		jugglersPerCircuit = jugglers.size() / circuits.size();
	}

	public void match(){
		for(Juggler juggler : jugglers){
			addToTeam(juggler);
		}
	}

	public void addToTeam(Juggler j){
		try{
			String circName = j.getFirstPreferance();
			int circNum = Integer.parseInt(circName.substring(1));
			String result = circuits.get(circNum).addMember(j, jugglersPerCircuit);
			if(!result.equals("SUCCESS")){
				int droppedJuggler = Integer.parseInt(result.substring(1));
				jugglers.get(droppedJuggler).removePreferance(circName);
				addToTeam(jugglers.get(droppedJuggler));
			}
		}
		catch(java.util.NoSuchElementException e){
			for(Circuit circuit: circuits){
				if(circuit.getTeamSize() < jugglersPerCircuit){
					circuit.addMember(j, jugglersPerCircuit);
					break;
				}
				
			}
		}
	}

	public void printEmailAddress(){
		System.out.println(circuits.get(1970));
		System.out.println("@yodle.com");
	}

	public void writeOutput(){
		try{
			outputFile = new File("output.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
			for(Circuit circuit : circuits){ 
				output.write(circuit.toString());
			}
			output.close();
		}
		catch(IOException e){
			System.err.println("IOException: " + e.getMessage());
		}
	}
}