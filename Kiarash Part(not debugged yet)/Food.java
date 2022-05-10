/**
* Name: Kiarash Kianidehkordi
* Date: April 1st 2022
* Description: The food class is one of the major classes in Super Auto pets, 
* this class allows the main class to 
* - use the ability of each food 
* - generate random food 
*/


import java.io.File;
import java. util. Arrays;
import java.io.FileReader;
import java.io.BufferedReader; 
import java.io.IOException;

public class Food {
   /** Food name */
   private String name; 
   /** the tier of each food */
   private int tier;  
   /** the ability of food in code form for processes */
   private int  ability; 
   /**the ability of the food in words*/
   private String abilityName;
  
  
  
   public Food () {
      this.name = "";
      this.tier = 0;
      this.ability = 0;
      this.abilityName= "";
      
   }

  
   /**
   Create an animal 
   @param name
   @param tier
   @param ability
   @param abilityName
   */
   public Food (String name, int tier, int ability,String abilityName) {
      this.name = name;
      this.tier = tier;
      this.ability = ability;
      this.abilityName= abilityName;
      
      // Restricting 
      if (tier < 0) {
         this.tier = 1;
      } else {
         this.tier = tier;
      }
   }
   
   /*
   Accessors
   */
      
   /**
   gets the food name
   @return the name of the food
   */
   public String getName() {
      return this.name;
   }
      
   /**
   gets the food tier o
   @return the tier of food 
   */
   public int getTier() {
      return this.tier;
   }
      
   /**
   gets the ability of the food
   @return the ability in code form 
   */
   public int getAbility () {
      return this.ability;
   }
      
   /**
   gets the ability of food in name 
   @return the ability of the food 
   */
   public String getAbilityName() {
      return this.abilityName;
   }
      
   /**
   read the information of a given food in an array which includes the attirbutes in the following order 
   */
   
   public void  generateFood (File address,String foodName) throws IOException
   {
   
     //Create a new filereader which allows the main to call it using the file address containing the food informations 
     FileReader fr= new FileReader(address);
     //
     BufferedReader br= new BufferedReader(fr);
     //
     String line;
      
     while ((line= br.readLine())!=null){
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i < 16 ; i++) {
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             
             
             //change the attirbutes of the food asked for by reading the textfile that contains the info of each food and finding the line that contains it
             if (words [1]==foodName){
             
               this.name= words[1];
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               this.tier=Integer.parseInt(words[0]);
               this.ability=Integer.parseInt(words[2]);
               this.abilityName=words[3];

             } 
         }
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close(); 
     
    }
    
    /**
    pick  a random food  from the list of 16 food in standard package, instead of taking the name of food from other classes
    @return a random food from the list that includes all the food info
    */
    
   public  void getRandomFood (File address)throws IOException
   
   {
     int foodNum = randomNumberGenerator(1, 16);//random number between 1 and 16 (number of food on the Foodlinfo.txt ) 
     //Create a new filereader which allows the main to call it using the file address containing the food informations 
     FileReader fr= new FileReader(address);
     //Create a new buffered reader 
     BufferedReader br= new BufferedReader(fr);
 
     String line;      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i <foodNum ; i++) {
               line= br.readLine();
               String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
               //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it             
               this.name= words[1];
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               this.tier=Integer.parseInt(words[0]);
               this.ability=Integer.parseInt(words[2]);
               this.abilityName=words[3];
             } 
             //closing the FileReader and bufferedReader
             br.close();
             fr.close(); 
    }
   
   /**
   allows the geneerateRandomAnimal method to choose a random food based on the # of lines in the database-textFile
   @returns a randomNum between the indicated range 
   */
   public static int randomNumberGenerator(int min, int max)
	{
		double r = Math.random();
		int randomNum = (int)(r * (max - min)) + min;//generate a random # using the random method of math class between the range of min and max
		return randomNum;
	}
   
   
  /*
     Method toString: returns all the attributes of the food 
  */
  public String toString(){
  
  
      return ("|name:"+(this.name)+"|tier:"+ (this.tier)+"|AbilityName :"+(this.abilityName)+ "|ability"+(this.ability));
      
       }
   
}



   
