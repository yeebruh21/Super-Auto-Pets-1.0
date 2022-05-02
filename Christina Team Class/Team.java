/**
* Name: Christina
* Date: 05/01/2022
* Description: This program is a team class, which includes the team's attributes, accessors, mutators, and methods.
*              The team consists of a number of animals, a name, number of trophies it has,
*              and the number of hearts (lives) it has.
*/

import java.io.*;
import java.util.*;

public class Team
{
   // Attributes
   /** number of animals on team */
   private int animalCount;
   
   /** number of hearts a team is left with */
   private int heartsLeft;
   
   /** number of trophies a team has */
   private int trophies;
   
   /** name of the team */
   private String teamName;
   
   /** animals on the team in order */
   //private Animal[] teamAnimals; // commented this line out because the Animal class is not finished by teammate
   
   /* Constructors*/
   // Default Constructor 
   /** 
   * Name: Team()
   * Description: default constructor sets the animal count to 0, hearts left to 10, trophies to 0, team name to "The", and teamAnimals to an unfilled array of length 5
   */
   public Team()
   {
      this.animalCount = 0;
      this.heartsLeft = 10;
      this.trophies = 0;
      this.teamName = "The"; // Every team name starts with "The"
      /*this.teamAnimals = new Animal[5];
      for (int i=0; i<5; i++)
      {
         teamAnimals[i] = " ";
      }*/
   }
   
   
   // Constructor 
	/**
	* Name: Team
	* Description: constructing a team in the Team class
	* @param animalCount - the number of animals on team
	* @param heartsLeft - the number of hearts of the team
	* @param trophies - the number of trophies the team has
   * @param teamName - the team name
	*/
   public Team (int animalCount, int heartsLeft, int trophies, String teamName) 
   {
      // Number of animals should be between 0 and 5. If above 5, assume 5; if below 0, assume 0
      if (animalCount>5)
      {
         this.animalCount = 5;
      }
      else if (animalCount<0)
      {
         this.animalCount = 0;
      }
      else
      {
         this.animalCount = animalCount;
      }
      
      // Restricting the team's hearts to be between 0 and 10. If above 10, assume 10; if below 0, assume 0
      if (heartsLeft>10)
      {
         this.heartsLeft = 10;
      }
      else if (heartsLeft<0)
      {
         this.heartsLeft = 0;
      }
      else
      {
         this.heartsLeft = heartsLeft;
      }
      
      // Restricting the team's trophy number to be between 0 and 10. If above 10, assume 10; if below 0, assume 0
      if (trophies>10)
      {
         this.trophies = 10;
      }
      else if (trophies<0)
      {
         this.trophies = 0;
      }
      else
      {
         this.trophies = trophies;
      }
      
      this.teamName = teamName;
      
      // Construct team animals (this constructor was commented out because the Animal class was not completed yet) 
      /*this.teamAnimals = new Animal[5];
      for (int i=0; i<5; i++)
      {
         teamAnimals[i] = " ";
      }*/
   }
   
   /*
   Accessors
   */
   
   /**
   * Name: getAnimalCount
	* Description: gets the number of animals on the team
	* @return - returns the int value of number of animals on the team
	*/
   public int getAnimalCount() 
   {
      return this.animalCount;
   }
   
   /**
   * Name: getHeartsLeft
	* Description: gets the number of hearts of the team
	* @return - returns the int value of number of hearts of the team
	*/
   public int getHeartsLeft() 
   {
      return this.heartsLeft;
   }
   
   /**
   * Name: getTrophies
	* Description: gets the number of trophies of the team
	* @return - returns the int value of number of trophies of the team
	*/
   public int getTrophies() 
   {
      return this.trophies;
   }
   
   /**
   * Name: getTeamName
	* Description: gets the team's name
	* @return - returns a String of team's name
	*/
   public String getTeamName() 
   {
      return this.teamName;
   }
   
   /*
   * Name: getTeamAnimals
	* Description: gets the animals of the team from left to right
	* @return - returns a String of the animals on the team
	*/
   /*
   public String getTeamAnimals() 
   {
      return this.teamAnimals[0]+" "+teamAnimals[1]+" "+teamAnimals[2]+" "+teamAnimals[3]+" "+teamAnimals[4];
   }
   */
   
   /*
   Other Methods
   */
   
   /** 
   * Name: printTeamNameChoices
   * Description: This method prints the available options for team names. A team name consists 
                  of three words: "The [adj] [noun]". Player has three options for adjectives 
                  and nouns, a total of six words will be printed.
   */
   public void printTeamNameChoices ()
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
      //int max = 4;
      for (int i=0; i<=2; i++)
      {
         randomIndex = (int)(Math.random()*(max-min+1)+min);
         wordChoices[i] = words[randomIndex];
      }
          
      // Get a noun from a random index of the words array
      min = 50;
      max = 99;
      for (int i=3; i<=5; i++)
      {
         randomIndex = (int)(Math.random()*(max-min+1)+min);
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
	* Name: toString
   * Description: return all the attributes of the team
   * @return - returns a String:  the animal count, hearts left, trophy number, team name, and the animals on team
	*/
   public String toString()
   {
      return "Number of Animals: " + this.animalCount + "\nHearts Left: " + this.heartsLeft 
      + "\nNumber of Trophies: " + this.trophies + "\nTeam Name: " + this.teamName;
      // The animals on team will be included once the animal class is finished
      // this.teamAnimals[0]+" "+teamAnimals[1]+" "+teamAnimals[2]+" "+teamAnimals[3]+" "+teamAnimals[4];
   }
}