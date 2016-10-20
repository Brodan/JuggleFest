import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Juggler{
	private String name;
	private int h;
	private int e;
	private int p;
	private ArrayList<Map> circuitPreferances = new ArrayList<Map>();
	//private ArrayList<String> circuitPreferances = new ArrayList<String>();
	private ArrayList<Integer> preferenceScores = new ArrayList<Integer>();

	/*Constructor */
	public Juggler(String name, String coordination, String endurance, String pizzazz, String circuits){
		this.name = name;
		h = Integer.parseInt(coordination.substring(2));
		e = Integer.parseInt(endurance.substring(2));
		p = Integer.parseInt(pizzazz.substring(2));
		/*Wow, this works.*/
		for(String item : circuits.split("[,]")){
			Map<String, Integer> map = new HashMap<String, Integer>();
			circuitPreferances.add(map);
		}
	}

	public int getCoordination(){
		return h;
	}

	public int getEndurance(){
		return e;
	}

	public int getPizzazz(){
		return p;
	}

	/* Return specific circuit number from a Juggler's preference list.*/
	public int getCircuit(int i){
		return(circuitPreferances.get(i));
	}

	public void setPreference(int i){
		//Integer.parseInt(item.substring(1))
	}

	/*Print a juggler in following format:
	  J6 C2:128 C1:31 C0:188.*/
	public String toString(){
		return("" + name);
	}
}
