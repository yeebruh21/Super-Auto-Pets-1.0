import java.io.IOException;
import java.util.Arrays;

/**
 * Name: Shuhan Zhang
 * Date: April 28, 2022
 * Description: Making the player class. The player class has methods that control every action and those methods call on other classes such as Battle, Animal, Shop, Team etc.
 */
public class Player {
	
	private int lives; 
	private int coins; 
	private int trophies;
	private String name;
	private int points=10000;
	private Team team;
	private Background background;
	private Hat hat;
	private Shop shop;
	
	
	public Player(String name, int lives, int trophies) throws IOException {
		this.name=name; 
		this.lives=lives;
		this.coins=20;
		this.trophies=trophies;
		this.team=new Team();
		this.background= new Background();
		this.hat= new Hat();
		this.shop=new Shop();

	}
	
	
	
	public boolean checkStatus() {
		if (this.lives<=0) {
			System.out.println("You lose");
			return false;
		}
		if (this.trophies==10) {
			System.out.println("You win");
			endGame();
			return false;
		}
		return true;
	}
	
	public void endGame() {
		if (this.trophies==10) {
			//+6 each round if 10 wins
			this.points+=60;
		} else {
			//+5 for each normal round
			this.points+=(this.trophies*5);
		}
	}
	
	public void battle(Player p1, Player p2, int round) throws IOException {
		Battle b = new Battle(p1, p2, round);
		Player winner=b.battle();
		if (winner.equals(p1)) {
			b.battleWon(p1);
			b.battleLost(p2);
			System.out.println(p1);
			System.out.println(p2);
		} else if (winner.equals(p2)) {
			b.battleWon(p2);
			b.battleLost(p1);
			System.out.println(p1);
			System.out.println(p2);
		}
		
	}
	
	public void buyPet(Animal a, int slot) {
		if (this.coins>3) {
			if (team.getAnimal(slot)!=null) {
				sellPet(slot);
			}
			for (int i=0; i<5; i++) {
				//If the object at index i is null, then don't bother checking 
				if (shop.getAnimalInShop(i)==null) {
					
				}else if (shop.getAnimalInShop(i).getName().equals(a.getName())) {
					shop.removeAnimalFromShop(i);
					break;
				}
			}
			team.setSlot(a, slot);
			this.coins-=3;
			System.out.println("Bought "+a.getName());
		} else {
			System.out.println("Not enough coins");
		}
	}
	
	public void sellPet(int slot) {
		if (team.getAnimal(slot)!=null) {
			team.setSlot(null, slot);
			this.coins++;
		}
	}
	
	public void newShop(Shop s) {
		this.shop=s;
	}
	
	public void roll () throws IOException {
		if (this.coins>=1) {
			shop.generateAnimalInShop();
			this.coins--;
		}
	}
	
	
	public void freezeAnimal(int slot) {
		this.shop.setFrozenAnimal(slot);
		System.out.println("Froze "+this.shop.getAnimalInShop(slot));
	}
	public void unfreezeAnimal(int slot) {
		this.shop.setUnfrozenAnimal(slot);
		System.out.println("Unfroze "+this.shop.getAnimalInShop(slot));
	}
	
	
	/**
	 * Checks the shop of backgrounds with their prices
	 */
	public void checkBackgroundShop() {
		System.out.println(background.getBackgrounds());
	}
	
	/**
	 * changes to a new background that is owned by the user
	 * @param backgroundChoice the new background the user wants to change to
	 */
	public void changeBackground(String backgroundChoice) {
		if (background.getOwnedBackgrounds().contains(backgroundChoice)) {
			background.setCurrentBackground(backgroundChoice);
			System.out.println("Map changed!");
		} else {
			System.out.println("You don't own this background");
		}
	}
	
	/** 
	 * Buying a background with points. If not enough points or if the shop doesn't have the background, nothing will happen. 
	 * @param backgroundchoice the background that the user is wishing to buy
	 */
	public void buyBackground(String backgroundchoice) {
		if (background.getBackgrounds().containsKey(backgroundchoice)) {
			int price = background.getBackgrounds().get(backgroundchoice);
			if (points>=price) {
				background.getOwnedBackgrounds().add(backgroundchoice);
				background.getBackgrounds().remove(backgroundchoice);
				points-=price;
				System.out.println("Bought the background!\nPoints left: "+points);
			} else {
				System.out.println("Not enough points");
			}
		} else {
			System.out.println("Pick a map from the list");
		}
	}
	
	public void buyHat(Hat h) {
		if (points>h.getCoinPrice()) {
			points-=h.getCoinPrice();
			this.hat=h;
		}
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public int getlives() {
		return this.lives;
	}
	
	public int getCoins() {
		return this.coins;
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
	public void setCoins(int newCoins) {
		this.coins=newCoins;
	}
	public void setTrophies(int newTrophies) {
		this.trophies=newTrophies;
	}
	public void setPoints(int newPoints) {
		this.points=newPoints;
	}
	public Team getTeam() {
		return this.team;
	}
	
	public String toString() {
		return this.name+" has/have "+this.lives+" lives left, and "+this.trophies+" trophies.";
	}

}
