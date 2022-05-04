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
	private static boolean continuegame=true;
	private Team t;
	private Background b;
	
	
	public Player(int lives, int money, int trophies) {
		this.lives=lives;
		this.money=money;
		this.trophies=trophies;
		this.t=new Team();
		this.b= new Background();
		
		
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
			//+6 each round if 10 wins
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
	
	/** 
	 * Buying a background with points. If not enough points or if the shop doesn't have the background, nothing will happen. 
	 * @param backgroundchoice the background that the user is wishing to buy
	 */
	public void buyBackground(String backgroundchoice) {
		if (b.getBackgrounds().containsKey(backgroundchoice)) {
			int price = b.getBackgrounds().get(backgroundchoice);
			if (points>price) {
				b.getOwnedBackgrounds().add(backgroundchoice);
				b.getBackgrounds().remove(backgroundchoice);
				points-=price;
				System.out.println("Points left: "+points);
			} else {
				System.out.println("Not enough points");
			}
		} else {
			System.out.println("Pick a map from the list");
		}
	}
	
	/**
	 * Checks the shop of backgrounds with their prices
	 */
	public void checkBackgroundShop() {
		System.out.println(b.getBackgrounds());
	}
	
	/**
	 * changes to a new background that is owned by the user
	 * @param backgroundChoice the new background the user wants to change to
	 */
	public void changeBackground(String backgroundChoice) {
		if (b.getOwnedBackgrounds().contains(backgroundChoice)) {
			b.setCurrentBackground(backgroundChoice);
			System.out.println("Map changed!");
		} else {
			System.out.println("You don't own this background");
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
