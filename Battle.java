import java.util.*;
public class Battle {
	Player p1;
	Player p2;
	Scanner sc;
	Animal[] p1temp, p2temp;



	public Battle(Player p1, Player p2, int round) {
		this.p1=p1;
		this.p2=p2;

		sc = new Scanner(System.in);

		p1temp = p1.getTeam().getTeamArray().clone();
		p2temp = p2.getTeam().getTeamArray().clone();

	}

	public void battle() {
		int i1=4;
		int i2=4;
		System.out.println("Battle starting: \n");
		while (true) {
			
			int atk1= p1.getTeam().getAnimal(i1).getAttack();
			int atk2= p2.getTeam().getAnimal(i2).getAttack();
			int hp1= p1.getTeam().getAnimal(i1).getHp();
			int hp2= p2.getTeam().getAnimal(i2).getHp();
			p1.getTeam().getAnimal(i1).setHp(hp1-atk2);
			p2.getTeam().getAnimal(i2).setHp(hp2-atk1);
			System.out.println(p1.getTeam().getAnimal(i1).getName()+" has "+p1.getTeam().getAnimal(i1).getHp()+" hp left.");
			System.out.println(p2.getTeam().getAnimal(i2).getName()+" has "+p2.getTeam().getAnimal(i2).getHp()+" hp left.");

			if (p1.getTeam().getAnimal(i1).getHp()<=0) {
				System.out.println(p1.getTeam().getAnimal(i1).getName()+" has fainted.");
				i1--;
				if(i1<0) {
					battleWon(p2);
					battleLost(p1);
					p1.getTeam().setTeamArray(p1temp);
					p2.getTeam().setTeamArray(p2temp);
					System.out.println("Player one wins");
					break;
				}
			}	
			if (p2.getTeam().getAnimal(i2).getHp()<=0) {
				System.out.println(p2.getTeam().getAnimal(i2).getName()+" has fainted.");
				i2--;
				if (i2<0) {
					battleWon(p1);
					battleLost(p2);
					p1.getTeam().setTeamArray(p1temp);
					p2.getTeam().setTeamArray(p2temp);
					System.out.println("Player 2 wins");
					break;
				}
			}

			System.out.println("type p to keep going or n to stop \n");
			String s= sc.next();
			if (s.toLowerCase().equals("p")) {

			} else if (s.toLowerCase().equals("n")) {
				break;
			} else {
				System.out.println("Type p or n \n");
			}


		}

	}
	public void battleWon(Player p) {
		p.setTrophies(p.getTrophies()+1);
	}
	public void battleLost(Player p) {
		//for now -1
		p.setLives(p.getlives()-1);
	}


}
