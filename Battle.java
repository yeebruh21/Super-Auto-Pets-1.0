import java.util.*;
/**
 * Name: Shuhan Zhang
 * Date: April 28, 2022
 * Description: Making the battle class. The battle class will pit the 2 player's animals together one by one. Player 1's (the player on the left side) starting animal 
 * will be at index 4 while Player 2's (the player on the right) starting animal will be at index 0. 3 abilities are implemented in battle. The winner of each battle gains
 * 1 trophy while the loser loses lives depending on the round number. The constructor will be called in the Player class and the Player class will have the method to battle
 */
public class Battle {
	/** The player on the left side, also the player the user controls */
	private Player p1;
	/** The player on the right side, also the player that the user is battling*/
	private Player p2;
	/** The round number*/
	private int round;
	/** The current index of the battling Animal in player 1's team*/
	private int i1;
	/** The current index of the Animal in player 2's team*/
	private int i2;
	/** The scanner to ask for user input*/
	private Scanner sc;
	/** The saved array for p1*/
	private Animal[] p1temp;
	/** The saved array for p2*/
	private Animal[] p2temp;


	/** Constructor to create a new battle
	 * 
	 * @param p1 The player on the left battling
	 * @param p2 The player on the right battling
	 * @param round The round number of the current battle
	 */
	public Battle(Player p1, Player p2, int round) {
		this.p1=p1;
		this.p2=p2;
		this.round=round;
		this.i1=4;
		this.i2=0;


		sc = new Scanner(System.in);

		//Saving the team to a temporary array so that any changes that happen in the battle wont affect the team after the battle.
		p1temp = p1.getTeam().getTeamArray().clone();
		p2temp = p2.getTeam().getTeamArray().clone();

	}
	
	/**
	 * The most crucial method in the class. The index of 
	 * @return The winner of the battle
	 */

	public Player battle() {

		boolean auto=false;
		System.out.println("\nBattle starting: \nP1: "+p1.getName()+" vs P2:"+p2.getName()+"\n");
		mosquitoAbility(p1, p2);
		mosquitoAbility(p2, p1);
		System.out.println();
		while (true) {

			int dmg1= p1.getTeam().getAnimal(i1).getDmg();
			int dmg2= p2.getTeam().getAnimal(i2).getDmg();
			String name1 = p1.getTeam().getAnimal(i1).getName();
			String name2 = p2.getTeam().getAnimal(i2).getName();
			p1.getTeam().getAnimal(i1).addHp(-dmg2);
			p2.getTeam().getAnimal(i2).addHp(-dmg1);
			System.out.println("P1: "+name1+" has "+ p1.getTeam().getAnimal(i1).getHp()+" hp left.");
			System.out.println("P2: "+name2+" has "+p2.getTeam().getAnimal(i2).getHp()+" hp left.");

			if (p1.getTeam().getAnimal(i1).getHp()<=0) {
				System.out.println(name1+" has fainted.");
				antAbility();
				cricketAbility();
				i1--;
				if(i1<0) {
					p1.getTeam().setTeamArray(p1temp);
					p2.getTeam().setTeamArray(p2temp);
					System.out.println(p2.getName()+" wins");
					return p2;
				}
			}	
			if (p2.getTeam().getAnimal(i2).getHp()<=0) {
				System.out.println(name2+" has fainted.");
				antAbility2();
				cricketAbility2();
				i2++;
				if (i2>4) {
					p1.getTeam().setTeamArray(p1temp);
					p2.getTeam().setTeamArray(p2temp);
					System.out.println(p1.getName()+" win");
					return p1;
				}
			}
			System.out.println();
			if (!auto) {
				System.out.println("Type p to keep going or auto to finish immediately ");
				String s= sc.next();
				if (s.toLowerCase().equals("p")) {

				} else if (s.toLowerCase().equals("auto")) {
					auto=true;
				} else {
					while(!(s.toLowerCase().equals("p")||s.toLowerCase().equals("auto"))) {
						System.out.println("Type p or auto");
						s=sc.next();
						if (s.toLowerCase().equals("auto")) {
							auto=true;
						}
					}
				}
			}


		}

	}

	public void antAbility() {
		if (p1.getTeam().getAnimal(i1).getName().equals("Ant")&& i1!=0) {
			int i=(int)(Math.random()*i1);
			p1.getTeam().getAnimal(i).addHp(1);
			p1.getTeam().getAnimal(i).addDmg(2);
			System.out.println("The fainted Ant gave "+p1.getTeam().getAnimal(i).getName()+" 2 damage and 1 hp.");
			System.out.println(p1.getTeam().getAnimal(i));
		}

	}
	public void antAbility2() {
		if (p2.getTeam().getAnimal(i2).getName().equals("Ant")&&i2!=4) {
			int i= i2+1+(int)(Math.random()*(4-i2));
			p2.getTeam().getAnimal(i).addHp(1);
			p2.getTeam().getAnimal(i).addDmg(2);
			System.out.println("The fainted Ant gave "+p2.getTeam().getAnimal(i).getName()+" 2 damage and 1 hp.");
			System.out.println(p2.getTeam().getAnimal(i));
		}
	}

	public void cricketAbility() {
		if (p1.getTeam().getAnimal(i1).getName().equals("Cricket")) {
			p1.getTeam().setSlot(new Animal("Weak Cricket", 1, 1, 1, 1), i1);
			System.out.println("Cricket fainted but spawned a 1/1 Weak Cricket!");
			i1++;
		}
	}
	public void cricketAbility2() {
		if (p2.getTeam().getAnimal(i2).getName().equals("Cricket")) {
			p2.getTeam().setSlot(new Animal("Weak Cricket", 1, 1, 1, 1), i2);
			System.out.println("Cricket fainted but spawned a 1/1 Weak Cricket!");
			i2--;
		}
	}

	public void mosquitoAbility(Player p, Player otherP) {
		int mosquitoCount = p.getTeam().animalCount(new Animal("Mosquito", 0, 0, 1, 1));
		if (mosquitoCount>0) {
			for (int i=0; i<mosquitoCount; i++) {
				int r=(int)(Math.random()*5);
				otherP.getTeam().getAnimal(r).addHp(-1);
				System.out.println(p.getName()+"'s mosquito did 1 damage to "+otherP.getName()+"'s "+otherP.getTeam().getAnimal(r).getName()+" and now has "+otherP.getTeam().getAnimal(r).getHp()+" hp.");
			}
		}
	}


	public void battleWon(Player p) {
		p.setTrophies(p.getTrophies()+1);
	}

	public void battleLost(Player p) {
		int livesLost;
		if (round>0 && round<2) {
			livesLost=1;
		} else if (round<5) {
			livesLost=2;
		} else {
			livesLost=3;
		}
		p.setLives(p.getlives()-livesLost);
	}


}
