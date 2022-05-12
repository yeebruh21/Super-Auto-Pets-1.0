import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Name: Christina
 * Date: 05/01/2022
 * Description: This program is a shop class, which consists of the shop in the game. The shop
 * has animals and foods which the player can buy.
 */
public class Shop
{
	// Attributes
	/** current animals in shop */
	private Animal [] animalInShop;


	/** whether a shop animal is frozen or not */
	private boolean [] frozenAnimalStatus;



	/* Constructor*/
	/** 
	 * Name: Shop(int turn)
	 * Description: initializes arrays depending on what turn it is, assume no frozen animals or food
	 * @throws IOException 
	 */
	public Shop() throws IOException
	{

		this.animalInShop = new Animal[5];
		this.frozenAnimalStatus = new boolean[5];

		generateAnimalInShop();
	}

	//Methods
	public void generateAnimalInShop () throws IOException
	{
		for (int i=0; i<this.animalInShop.length; i++)
		{
			if (this.frozenAnimalStatus[i]==false)
			{
				this.animalInShop[i]=Animal.getRandomAnimal(new File("SuperAutoPetsInfo.txt"));
			}
		}
	}

	public boolean contains(Animal a) {
		for (Animal aa: this.animalInShop) {
			if (aa==null) {
				
			} else if (aa.getName().equals(a.getName())) {
				return true;
			}
		}
		return false;
	}

	public void removeAnimalFromShop (int slot)
	{
		this.animalInShop[slot] = null;
		
	}
	
	public void setFrozenAnimal(int slot) {
		this.frozenAnimalStatus[slot]=true;
	}

	public void setUnfrozenAnimal(int slot) {
		this.frozenAnimalStatus[slot]=false;
	}
	
	public Animal[] getAnimalsInShop() {
		return this.animalInShop;
	}
	public Animal getAnimalInShop(int slot) {
		return this.animalInShop[slot];
	}
	
	public String toString() {
		return "Current shop: "+ Arrays.toString(this.animalInShop);
	}
}
