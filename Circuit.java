import java.util.ArrayList;

public class Circuit{
	private String name;
	private int h;
	private int e;
	private int p;
	private ArrayList<Juggler> team = new ArrayList<Juggler>();

	public Circuit(String name, String coordination, String endurance, String pizzazz){
		this.name = name;
		h = Integer.parseInt(coordination.substring(2));
		e = Integer.parseInt(endurance.substring(2));
		p = Integer.parseInt(pizzazz.substring(2));
	}

	/* Place a juggler onto this circuit's team, as long as the team size hasn't been exceeded.*/
	public void addMember(Juggler j, int teamSize){
		if(team.size() < teamSize){
			team.add(j);
		}
	}

	/* Sorts the team in order of dot product with each team member.*/
	public void sortTeam(){

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

	/* Print a circuit in the following format:
	C2 J6 C2:128 C1:31 C0:188, J3 C2:120 C0:171 C1:31, J10 C0:120 C2:86 C1:21, J0 C2:83 C0:104 C1:17 */
	public String toString(){
		return(name + " " + team.toString() + "\n");
	}
}