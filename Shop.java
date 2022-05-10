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

	/** current foods in shop */
	private Food [] foodInShop;

	/** whether a shop animal is frozen or not */
	private boolean [] frozenAnimalStatus;

	/** wehther a shop food is frozen or not */
	private boolean [] frozenFoodStatus;


	/* Constructor*/
	/** 
	 * Name: Shop(int turn)
	 * Description: initializes arrays depending on what turn it is, assume no frozen animals or food
	 * @throws IOException 
	 */
	public Shop() throws IOException
	{
//		int maxAnimalIndex = 0;
//		int maxFoodIndex = 2;
//		if (turn<5)
//		{
//			maxAnimalIndex = 3;
//			if (turn<3)
//			{
//				maxFoodIndex = 1;
//			}
//		}
//		else if (turn<9)
//		{
//			maxAnimalIndex = 4;
//		}
//		else
//		{
//			maxAnimalIndex = 5;
//		}

		this.animalInShop = new Animal[5];
		this.frozenAnimalStatus = new boolean[5];

		this.foodInShop = new Food[2];
		this.frozenFoodStatus = new boolean[2];
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

//	public  void generateFoodInShop ()
//	{
//		for (int i=0; i<this.foodInShop.size; i++)
//		{
//			if (this.frozenAnimalStatus[i]!=false)
//			{
//				this.foodInShop[i]=Food.getRandomFood();
//			}
//		}
//	}


//	public void freezeFood (int slot)
//	{
//		if (this.animalInShop[slot-1]!=null)
//		{
//			this.frozenFoodStatus[slot-1] = true;
//		}
//	}
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
		return Arrays.toString(this.animalInShop);
	}
}
