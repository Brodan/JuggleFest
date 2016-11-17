import java.util.Map;
import java.util.LinkedHashMap;

public class Juggler{
	private String name;
	private Map<String, Integer> circuitPreferances = new LinkedHashMap<String, Integer>();

	/*Constructor */
	public Juggler(String name, Map<String, Integer> circuitPreferances){
		this.name = name;
		this.circuitPreferances = circuitPreferances;
	}

	public String getName(){
		return name;
	}

	/* Return a dot product score for a particular circuit. */
	public int getPreferanceScore(String circuit){
		try{
			return(circuitPreferances.get(circuit));
		}
		catch(java.lang.NullPointerException e){
			return(0);
		}
		
	}

	/* Return first circuit from a Juggler's preference list.*/
	public String getFirstPreferance(){
		return(circuitPreferances.entrySet().iterator().next().getKey());
	}

	/* Remove specific circuit from preferance list. */
	public void removePreferance(String circuit){
		circuitPreferances.remove(circuit);
	}

	/*Print a juggler in following format:
	  J6 C2:128 C1:31 C0:188.*/
	public String toString(){
		String output = name;
		for(Map.Entry<String, Integer> preference : circuitPreferances.entrySet()){
			output += " " + preference.getKey() + ":" + preference.getValue();
		}
		return(output);
	}
}
