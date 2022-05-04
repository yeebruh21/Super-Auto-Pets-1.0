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

import java.io.File;
import java. util. Arrays;
import java.io.FileReader;
import java.io.BufferedReader; 
import java.io.IOException;

public class Animal {
   /** Animal name */
   private String name;
   
   /** animal health  */
   private int health;
   
   /** number of directAttack */
   private int directAttack;
   
   /** the level of each animal */
   private int level;
   
   /** the tier of each animal */
   private int tier;
   
   /** the ability of each animal */
   private String ability;
   
   /**
   Create an animal 
   @param name
   @param health
   @param directAttack
   @param level
   @param tier
   @param ability 
   */
   public Animal(String name, int health, int directAttack, int level, int tier,String ability) {
      this.name = name;
      this.health = health;
      this.directAttack = directAttack;
      this.level = level;
      this.tier = tier;
      this.ability= ability;
      
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
   public int getHealth() {
      return this.health;
   }
      
   /**
   gets the directAttack of the animal as level one
   @return the direct attack
   */
   public int getDirectAttack () {
      return this.directAttack;
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
      
   /**
   gets the ability of animal 
   @return the ability in code form
   */
   public String getAbility() {
      return this.ability;
   }
   
   
   
   /**
   read the information of a given animal in an array which includes the attirbutes in the following order 
   name, health, directAttack,level,tier, ability
   */
   
   public void  generateAnimal (File address,String animalName) throws IOException
   {
   
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //
     BufferedReader br= new BufferedReader(fr);
     //
     String line;
      
     while ((line= br.readLine())!=null){
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i < 81 ; i++) {
             int currIndex = 1; //used to count which letter we're at
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             
             
             //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
             if (words [0]==animalName){
             
               this.name= words[0];
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               this.health=Integer.parseInt(words[1]);
               this.directAttack=Integer.parseInt(words[2]);
               this.level=Integer.parseInt(words[3]);
               this.tier=Integer.parseInt(words[4]);
               
               this.ability=words[5];

             } 
         }
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close(); 
     
    }
    
    /**
    pick  a random level 1 animal from the list of 63 animals in standard package, instead of taking the name of animal from other classes
    */
    
   public String getRandomAnimal (File address)throws IOException
   
   {
      String animalName="";
      int animal = randomNumberGenerator(1, 63);//random number between 1 and 63 (number of animals on the animalinfo.txt ) 
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //
     BufferedReader br= new BufferedReader(fr);
     //
     String line;
      
     while ((line= br.readLine())!=null){
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i <animal ; i++) {
         
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
             if (words [0]==animalName){
             
               this.name= words[0];
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               this.health=Integer.parseInt(words[1]);
               this.directAttack=Integer.parseInt(words[2]);
               this.level=Integer.parseInt(words[3]);
               this.tier=Integer.parseInt(words[4]);
               this.ability=words[5];
               animalName=this.name;

             } 
         }
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close(); 
     
   
      return animalName;
   }
   
   /**
   allows the geneerateRandomAnimal method to choose a random animal based on the # of lines in the database-textFile
   */
   public static int randomNumberGenerator(int min, int max)
	{
		double r = Math.random();
		int randomNum = (int)(r * (max - min)) + min;//generate a random # using the random method of math class between the range of min and max
		return randomNum;
	}
}
