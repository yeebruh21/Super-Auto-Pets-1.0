import java.util.*;
/**
 * Name: Shuhan Zhang
 * Date: April 28, 2022
 * Description: Making the background class
 */
public class Background {

	private String currentBackground;
	private HashMap<String, Integer> backgrounds=new HashMap<String, Integer>();
	private ArrayList<String> owned = new ArrayList<String>();


	public Background(){

		backgrounds.put("Grass Field", 0);
		backgrounds.put("Hot Desert", 5000);
		backgrounds.put("Lava Mountain", 5000);
		backgrounds.put("Scary Forest", 5000);
		backgrounds.put("Underground Cave", 500);
		backgrounds.put("Snowy Mountain", 500);
		backgrounds.put("Lava Cave", 1000);
	}
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
	public void checkShop() {
		System.out.println(backgrounds);
	}


	public void changeBackground(String backgroundChoice) {
		if (owned.contains(backgroundChoice)) {
			this.currentBackground= backgroundChoice;
			System.out.println("Map changed!");
		}
	}
	public String getBackground() {
		return this.currentBackground;
	}





}
