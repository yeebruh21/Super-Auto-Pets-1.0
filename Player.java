/**
 * Name: Shuhan Zhang
 * Date: April 28, 2022
 * Description: Making the player class
 */
public class Player {
	
	private int lives; 
	private int money; 
	private int trophies;
	private int points=10000;
	public static boolean continuegame=true;
	private Team t = new Team();
	
	
	public Player(int lives, int money, int trophies) {
		this.lives=lives;
		this.money=money;
		this.trophies=trophies;
		
		
	}
	
	
	
	public boolean checkStatus() {
		if (this.lives<=0) {
			System.out.println("You lose");
			continuegame=false;
			return false;
		}
		if (this.trophies==10) {
			System.out.println("You win");
			continuegame=false;
			return false;
		}
		return true;
	}
	
	public void endgame(Player p) {
		if (this.trophies==10) {
			//+6 each round if 10 wins. -45+60=+12
			this.points+=60;
		} else {
			//+5 for each normal round
			this.points+=(this.trophies*5);
		}
	}
	
	public void battle(Player p1, Player p2, int round) {
		Battle b = new Battle(p1, p2, round);
		b.battle();
	}
	
	public void buyBackground(String backgroundchoice) {
		if (backgrounds.containsKey(backgroundchoice)) {
			int price = backgrounds.get(backgroundchoice);
			if (p.getPoints()>price) {
				owned.add(backgroundchoice);
				backgrounds.remove(backgroundchoice);
				p.setPoints(p.getPoints()-price);
				System.out.println("Points left: "+p.getPoints());
			} else {
				System.out.println("Not enough points");
			}
		} else {
			System.out.println("Pick a map from the list");
		}
	}
	
	
	
	public int getlives() {
		return this.lives;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getTrophies() {
		return this.trophies;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setLives(int newLives) {
		this.lives=newLives;
	}
	public void setMoney(int newMoney) {
		this.money=newMoney;
	}
	public void setTrophies(int newTrophies) {
		this.trophies=newTrophies;
	}
	public void setPoints(int newPoints) {
		this.points=newPoints;
	}
	public Team getTeam() {
		return this.t;
	}

}
