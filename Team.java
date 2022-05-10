/**
 * Name: Christina
 * Date: 05/10/2022
 * Description: This program is a team class, which includes the team's attributes, accessors, mutators, and methods.
 *              The team consists of a number of animals, a name, number of trophies it has,
 *              and the number of hearts (lives) it has. 
 */

import java.io.*;
import java.util.*;

public class Team
{
	// Attributes

	/** name of the team */
	private String teamName;

	/** animals on the team in order */
	private Animal[] teamAnimals; 


	/* Constructors*/
	// Default Constructor 
	/** 
	* Name: Team()
	* Description: default constructor sets the animal count to 0, team name to "The", and teamAnimals to an unfilled array of length 5
	*/
	public Team()
	{
		this.teamName = "The"; // Every team name starts with "The"
		this.teamAnimals = new Animal[5];
	}


	/*
   Accessors
	 */


	/**
	* Name: getTeamName
	* Description: gets the team's name
	* @return - returns a String of team's name
	*/
	public String getTeamName() 
	{
		return this.teamName;
	}

   /**
	* Name: getAnimal
	* Description: gets the animal in a specific slot
	* @return - returns an Animal object which is the animal in that slot
	*/
	public Animal getAnimal(int slot) 
   {
		return this.teamAnimals[slot];
	}
   
   /**
	* Name: getTeamArray
	* Description: gets the array that stores all the animals in team
	* @return - returns the Animal array which has all the animals in team
	*/
	public Animal[] getTeamArray() 
   {
		return this.teamAnimals;
	}
   

	/*
   Other Methods
	 */

	/** 
	 * Name: printTeamNameChoices
	 * Description: This method prints the available options for team names. A team name consists 
                  of three words: "The [adj] [noun]". Player has three options for adjectives 
                  and nouns, a total of six words will be printed.
     * @return String array of the choices for team name
	 */
	public String[] printTeamNameChoices ()
	{
		// Variable Declaration
		int randomIndex = 0; // a random index for the words and wordChoices arrays
		int count = 0; // current index number of the words array, equals current line number in file -1

		// Read from a file of adjectives and nouns, and store the words from file in an array named words
		String fileName = "AdjAndNoun.txt";
		File wordList = new File(fileName);
		String[] words = new String[100]; 
		try
		{
			String line; // a line from the file
			BufferedReader br = new BufferedReader(new FileReader(wordList));

			// Adds a line (word) into the next index of the words array
			while((line=br.readLine())!=null)
			{
				words[count] = line;
				count++;
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("file \"" + fileName + "\" not found: " + e);
		}
		catch (IOException e)
		{
			System.out.println("Input Output Exceptions: " + e);
		}

		// The WordChoices array will hold six words, 3 each for adj and noun
		String[] wordChoices = new String[6];

		// Get an adj from a random index of the words array
		// Adjectives in the file are located from line 1 to line 50, corresponding to index 0 to 49 in the array
		int min = 0;
		int max = 49;
		int [] usedIndex = new int[3];
		usedIndex[0] = -1;
		usedIndex[1] = -1;

		for (int i=0; i<=2; i++)
		{
			do
			{
				randomIndex = (int)(Math.random()*(max-min+1)+min);
				usedIndex[i] = randomIndex;
			}while (randomIndex == usedIndex[0] && randomIndex == usedIndex[1]);
			wordChoices[i] = words[randomIndex];
		}

		// Get a noun from a random index of the words array
		min = 50;
		max = 99;
		for (int i=3; i<=5; i++)
		{
			do
			{
				randomIndex = (int)(Math.random()*(max-min+1)+min);
				usedIndex[i] = randomIndex;
			}while (randomIndex == usedIndex[0] && randomIndex == usedIndex[1]);
			wordChoices[i] = words[randomIndex];
		}

		// Print the 3 adjective choices and 3 noun choice
		System.out.println("The ___ ___"); // Current name only contains "The"
		System.out.println("Adjective Choices:");
		System.out.println("1. " + wordChoices[0]);
		System.out.println("2. " + wordChoices[1]);
		System.out.println("3. " + wordChoices[2]);
		System.out.println("Noun Choices:");
		System.out.println("4. " + wordChoices[3]);
		System.out.println("5. " + wordChoices[4]);
		System.out.println("6. " + wordChoices[5]);
		
		// Return the wordChoices array
		return wordChoices;
	}
	
	/**
	* Name: chooseTeamName
	* Description: Player chooses their team name from the given three options for adj and noun.
	* @param wordChoices - the String array named wordChoices created in the printTeamNameChoices
	*                      method.
	*/
	public void chooseTeamName(String[] wordChoices)
	{
		// Variable Declaration and Scanner creation
		String [] teamNameArray = new String [3];
		int adjChoice, nounChoice; 
		Scanner sc = new Scanner(System.in);
      
      // This try catch block lets the player choose their team name
      try
      {
         // User enters a number between 1 to 3 for their adj. Keep prompting the user if number is invalid.
         do
         {
            System.out.println("Enter a number 1, 2, or 3 for your adjective: ");
            adjChoice = sc.nextInt();
         } while (adjChoice!=1 && adjChoice!=2 && adjChoice!=3);
         
         teamNameArray[0] = "The"; // Every team name starts with the word "The"
         
         // Get the corresponding element (adj) from the wordChoices array and fills the word in the teamName array
         teamNameArray[1] = wordChoices[adjChoice-1];
         
         // User enters a number between 4 to 6 for their noun. Keep prompting the user if number is invalid.
         do
         {
            System.out.println("Enter a number 4, 5, or 6 for your noun: ");
            nounChoice = sc.nextInt();
         } while (nounChoice!=4 && nounChoice!=5 && nounChoice!=6);
      
         // Get the corresponding element (noun) from the wordChoices array and fills the word in the teamName array
         teamNameArray[2] = wordChoices[nounChoice-1];
      }
      catch (InputMismatchException e)
      {
         System.out.println("Input Mismatch Exception: " + e);
      }
		
		// Print the team name
		System.out.println("Your team name is: ");
		System.out.println(teamNameArray[0] + teamNameArray[1] + " " + teamNameArray[2]);

		//store the name in the actual teamName object
		this.teamName = (teamNameArray[0]+" "+teamNameArray[1]+" "+teamNameArray[2]);
	}

   /**
	* Name: setTeamArray
	* Description: gets the array that stores all the animals in team
   * @param newTeam: a new team of animals
	*/
	public void setTeamArray(Animal[] newTeam) 
   {
		this.teamAnimals=newTeam;
	}

	/**
	* Name: setSlot
	* Description: Sets the slot where the animal is put in
	* @param a: the animal which should be put in a slot
   * @param slot: the slot which the animal is put in
	*/
	public void setSlot(Animal a, int slot) 
   {
		this.teamAnimals[slot]=a;
	}
   
   /**
	* Name: animalCount
	* Description: counts the number of a specific animal in the team
	* @param a: the animal being counted
   * @return - an integer value of the number of animal a
	*/
	public int animalCount(Animal a) 
   {	
		int count=0;
		for (Animal aa:this.teamAnimals) 
      {
			if (aa.getName().equals(a.getName()))
         {
				count++;
			}
		}
		return count;
	}
	
   /**
	* Name: exchangePositions
	* Description: swap positions of two animals in team
	* @param slot1: the slot where the first animal is in
   * @param slot2: the slot where the second animal is in
	*/
	public void exchangePositions(int slot1, int slot2) 
   {
		Animal temp= this.teamAnimals[slot1];
		this.teamAnimals[slot1]=this.teamAnimals[slot2];
		this.teamAnimals[slot2]=temp;
	}
   
	/**
	* Name: toString
	* Description: return all the attributes of the team
	* @return - returns a String:  the animal count, hearts left, trophy number, team name, and the animals on team
	*/
	public String toString() 
   {
		return "Animals on team currently: "+this.teamAnimals[0]+" "+this.teamAnimals[1]+" "+this.teamAnimals[2]+" "+this.teamAnimals[3]+" "+this.teamAnimals[4];
	}

}
