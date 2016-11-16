	import java.util.List;
import java.util.ArrayList;

public class Circuit{
	private String name; //C0
	private int h; //10
	private int e; //8 
	private int p; //10
	private ArrayList<Juggler> team = new ArrayList<Juggler>();

	public Circuit(String name, String coordination, String endurance, String pizzazz){
		this.name = name;
		h = Integer.parseInt(coordination.substring(2));
		e = Integer.parseInt(endurance.substring(2));
		p = Integer.parseInt(pizzazz.substring(2));
	}

	/* Place a juggler onto this circuit's team. If team's size has exceeded, player with 
	 * lowest dot product is removed from team.
	 */
	public String addMember(Juggler j, int maxTeamSize){
		String result;
		if(team.size() < maxTeamSize){
		 	team.add(j);
		 	result = "SUCCESS";
		}
		else{
		 	int lowestScore = j.getPreferanceScore(name);
		 	int jugglerIndex = -1;
			result = j.getName();
			for(Juggler juggler : team){
		 		int currentScore = juggler.getPreferanceScore(name);
		 		if(currentScore < lowestScore){
		 			result = juggler.getName();
		 			lowestScore = currentScore;
		 			jugglerIndex = team.indexOf(juggler);
		 		}
		 	}
		 	if(jugglerIndex != -1){
				team.remove(jugglerIndex);
				team.add(j);
		 	}
		}
		return(result);
	}

	public String getName(){
		return name;
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

	public int getTeamSize(){
		return team.size();
	}

	/* Print a circuit in the following format:
	C2 J6 C2:128 C1:31 C0:188, J3 C2:120 C0:171 C1:31, J10 C0:120 C2:86 C1:21, J0 C2:83 C0:104 C1:17 */
	public String toString(){
		String output = name;
		for(Juggler juggler : team){
			output += " " + juggler.toString() + ",";
		}
		return(output + "\n");
	}
}