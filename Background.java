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
	 * getting the hashmap of backgrounds
	 * @return All of the backgrounds in the shop
	 */
	public HashMap<String, Integer> getBackgrounds() {
		return this.backgrounds;
	}
	
	
	/**
	 * getting the arraylist of owned backgrounds that the user purchased with points
	 * @return the arraylist of owned backgrounds
	 */
	public ArrayList<String> getOwnedBackgrounds(){
		return this.owned;
	}
	
	
	/**
	 * sets the current background to a new one
	 */
	public void setCurrentBackground(String newBackground) {
		this.currentBackground=newBackground;
	}
	
	
	/**
	 * to string method to print out current background and amount of owned backgrounds
	 * @return the current background and the amount of backgrounds owned.
	 */
	public String toString() {
		return "Current background: "+this.currentBackground + "\nBackgrounds owned: "+this.owned.size();
	}


}
