import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map;

public class Juggler{
	private String name;
	// {C1927=32, C351=96, C81=0, C271=64, C1630=84, C1287=20, C1314=56, C69=96, C127=36, C1797=84}
	private Map<String, Integer> circuitPreferances = new LinkedHashMap<String, Integer>();

	/*Constructor */
	public Juggler(String name, Map<String, Integer> circuitPreferances){
		this.name = name;
		this.circuitPreferances = circuitPreferances;
	}

	public String getName(){
		return name;
	}

	public int getPreferanceScore(String circuit){
		if(circuitPreferances.size()==0){
			return(0);
		}
		return(circuitPreferances.get(circuit)); 
	}

	/* Return first circuit from a Juggler's preference list.*/
	public String getFirstPreferance(){
		return(circuitPreferances.entrySet().iterator().next().getKey()); //C0
	}

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
