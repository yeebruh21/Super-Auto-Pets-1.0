/**
* Name: Kiarash Kianidehkordi
* Date: April 1st 2022
* Description: The animal class is one of the major classes in Super Auto pets, 
* this class allows the main class to 
* - use the ability of each animal as well as 
* - generate random animal for the lobby class 
* - make animal attack each other 
* - allow animal eat food 
*/

import java.io.*;
import java.util.Arrays;

public class Animal {
	/** Animal name */
	private String name;

	/** animal health  */
	private int hp;

	/** number of directAttack */
	private int damage;

	/** the level of each animal */
	private int level;

	/** the tier of each animal */
	private int tier;


	/**
   Create an animal 
   @param name
   @param health
   @param directAttack
   @param level
   @param tier
   @param ability 
	 */
	public Animal () {
		
	}
	public Animal(String name, int damage, int hp, int level, int tier) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.level = level;
		this.tier = tier;

		// Restricting 
		if (tier < 0) {
			this.level = 1;
		} else {
			this.level = level;
		}
	}

	/*
   Accessors
	 */

	/**
   gets the Animal name
   @return the name of the Animal
	 */
	public String getName() {
		return this.name;
	}

	/**
   gets the animal level one health
   @return the health of animal as level one
	 */
	public int getHp() {
		return this.hp;
	}

	/**
   gets the directAttack of the animal as level one
   @return the direct attack
	 */
	public int getDmg () {
		return this.damage;
	}

	/**
   gets the level of animal 
   @return the animal level
	 */
	public int getLevel() {
		return this.level;
	}

	/**
   gets the tier of animal 
   @return the tier of animal
	 */
	public int getTier() {
		return this.tier;
	}



	public void addHp(int addedHp) {
		this.hp+=addedHp;
	}
	public void addDmg(int addedDmg) {
		this.damage+=addedDmg;
	}

	public String toString() {
		return this.name+ " dmg: "+this.damage+" hp: "+this.hp;
	}


	/**
   read the information of a given animal in an array which includes the attirbutes in the following order 
   name, health, directAttack,level,tier, ability
	 */

	public static Animal generateAnimal (File address,String animalName) throws IOException
	{

		//Create a new filereader which allows the main to call it using the file address containing the animal informations 
		FileReader fr= new FileReader(address);
		//
		BufferedReader br= new BufferedReader(fr);
		//
		String line;
		
		String name=null;
		int hp=0;
		int damage=0;
		int level=0;
		int tier=0;

		while ((line= br.readLine())!=null){

			//first loop, check for all the words inside the sentence
			for (int i = 0; i < 10 ; i++) {
				int currIndex = 1; //used to count which letter we're at
				String [] words = line.split(","); //spliting the sentence into words and saving it inside an array

				//change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
				if (words[0].equals(animalName)){

					name= words[0];
					//casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
					hp=Integer.parseInt(words[1]);
					damage=Integer.parseInt(words[2]);
					level=Integer.parseInt(words[3]);
					tier=Integer.parseInt(words[4]);
					break;
				} 
			}

		}
		//closing the FileReader and bufferedReader
		Animal a = new Animal(name, damage, hp, level, tier);
		br.close();
		fr.close();
		return a; 

	}

	/**
    pick  a random level 1 animal from the list of 63 animals in standard package, instead of taking the name of animal from other classes
    @return a random animal from the list that includes all the animal info
	 */

	public static Animal getRandomAnimal (File address)throws IOException

	{
		int animalNum = randomNumberGenerator(1, 10);//random number between 1 and 63 (number of animals on the animalinfo.txt ) 
		//Create a new filereader which allows the main to call it using the file address containing the animal informations 
		FileReader fr= new FileReader(address);
		//
		BufferedReader br= new BufferedReader(fr);
		//
		String line;  
		String name=null;
		int hp=0;
		int damage=0;
		int level=0;
		int tier=0;
		//first loop, check for all the words inside the sentence
		for (int i = 0; i <animalNum ; i++) {
			line= br.readLine();
			String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
			//change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it             
			name= words[0];
			//casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
			hp=Integer.parseInt(words[1]);
			damage=Integer.parseInt(words[2]);
			level=Integer.parseInt(words[3]);
			tier=Integer.parseInt(words[4]);
			
		} 
		Animal a = new Animal(name, damage, hp, level, tier);
		//closing the FileReader and bufferedReader
		br.close();
		fr.close();
		return a; 
	}

	/**
   allows the geneerateRandomAnimal method to choose a random animal based on the # of lines in the database-textFile
   @returns a randomNum between the indicated range 
	 */
	public static int randomNumberGenerator(int min, int max)
	{
		double r = Math.random();
		int randomNum = (int)(r * (max - min)) + min;//generate a random # using the random method of math class between the range of min and max
		return randomNum;
	}
}

