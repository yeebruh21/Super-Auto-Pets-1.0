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
import java.io.FileReader;
import java.io.BufferedReader; 
import java.io.IOException;

public class Animal {
   /** Animal name */
   private String name;
   
   /** external colour */
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
   
   /*
   public static void readLines(File address) throws IOException{
      //
      FileReader fr= new FileReader(address);
      //
      BufferedReader br= new BufferedReader(fr);
      //
      String line;
      
      while ((line= br.readLine())!=null){
      //inputing the new line of code 
      String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
      
      //first loop, check for all the words inside the sentence
      for (int i = 0; i < words.length; i++) {
         int currIndex = 1; //used to count which letter we're at
      //holding the first char of a word to change it with the last char of the word
         holder1=words[i].charAt(0);
         holder2=(words[i].charAt(words[i].length()-1));
         System.out.print(holder2);
            
         //adding 2 to the ascii value of the  all the characters in between and printing them     
         while (currIndex < (words[i].length())-1){
 
            (char)((words[].charAt(currIndex))+2));   
            currIndex++; //increment counter
         }         
      }
      
      }
      br.close();
      fr.close();
   
   
   
   
   }
   */
}