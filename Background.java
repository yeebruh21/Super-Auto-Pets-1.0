import java.util.*;
/**
 * Name: Shuhan Zhang
 * Date: April 28, 2022
 * Description: Making the background class
 */
public class Background {

	/** The name of the current background equipped*/
	private String currentBackground;
	/** Hashmap of the shops and prices*/
	private HashMap<String, Integer> backgrounds=new HashMap<String, Integer>();
	/** Arraylist of the owned maps*/
	private ArrayList<String> owned = new ArrayList<String>();


	/**
	 * The constructor for the background class. Initializes the available backgrounds in the game.
	 */
	public Background(){
		backgrounds.put("Grass Field", 0);
		backgrounds.put("Hot Desert", 5000);
		backgrounds.put("Lava Mountain", 5000);
		backgrounds.put("Scary Forest", 5000);
		backgrounds.put("Underground Cave", 500);
		backgrounds.put("Snowy Mountain", 500);
		backgrounds.put("Lava Cave", 1000);
	}
	
	/** 
	 * Buying a background with points. If not enough points or if the shop doesn't have the background, nothing will happen. 
	 * @param backgroundchoice the background that the user is wishing to buy
	 */
	public void buyBackground(String backgroundchoice) {
		if (backgrounds.containsKey(backgroundchoice)) {
			int price = backgrounds.get(backgroundchoice);
			if (Player.points>price) {
				owned.add(backgroundchoice);
				backgrounds.remove(backgroundchoice);
				Player.points-=price;
				System.out.println("Points left: "+Player.points);
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
	public void checkShop() {
		System.out.println(backgrounds);
	}


	/**
	 * changes to a new background that is owned by the user
	 * @param backgroundChoice the new background the user wants to change to
	 */
	public void changeBackground(String backgroundChoice) {
		if (owned.contains(backgroundChoice)) {
			this.currentBackground= backgroundChoice;
			System.out.println("Map changed!");
		} else {
			System.out.println("You don't own this background");
		}
	}
	
	/**
	 * get the currently equipped background
	 * @return the current background
	 */
	public String getBackground() {
		return this.currentBackground;
	}





}
