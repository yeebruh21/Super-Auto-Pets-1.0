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
   private int ability;
   /** the ability of an animal as a string*/
   private String abilityName;
   
   
   
   public Animal() {
      this.name = "";
      this.health = 0;
      this.directAttack = 0;
      this.level = 0;
      this.tier = 0;
      this.ability= 0;
      this.abilityName="";
      
      // Restricting 
      if (this.level < 0) {
         this.level = 1;
      } else {
         this.level = level;
      }
   }
      
   /**
   Create an animal 
   @param name
   @param health
   @param directAttack
   @param level
   @param tier
   @param ability 
   
   */
   public Animal(String name, int health, int directAttack, int level, int tier,int ability) {
      this.name = name;
      this.health = health;
      this.directAttack = directAttack;
      this.level = level;
      this.tier = tier;
      this.ability= ability;
      this.abilityName=abilityName;
      
      // Restricting 
      if (this.level < 0) {
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
   public int getAbility() {
      return this.ability;
   }
   
   
   /**
   gets the ability of animal in words
   @return the ability in words
   */
   public String getAbilityName(){
      return this.abilityName;
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
               this.ability=Integer.parseInt(words[5]);


             } 
         }
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close(); 
     
    }
    
    /**
    pick  a random level 1 animal from the list of 63 animals in standard package, instead of taking the name of animal from other classes
    @return a random animal from the list that includes all the animal info
    */
    
   public  void getRandomAnimal (File address)throws IOException
   
   {
     int animalNum = randomNumberGenerator(1, 10);//random number between 1 and 63 (number of animals on the animalinfo.txt ) 
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //Create a new buffered reader 
     BufferedReader br= new BufferedReader(fr);
 
     String line;      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i <animalNum ; i++) {
               line= br.readLine();
               String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
               //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it             
               this.name= words[0];
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               this.health=Integer.parseInt(words[1]);
               this.directAttack=Integer.parseInt(words[2]);
               this.level=Integer.parseInt(words[3]);
               this.tier=Integer.parseInt(words[4]);
               this.ability=Integer.parseInt (words[5]);
               this.abilityName=words[6];
             } 
             //closing the FileReader and bufferedReader
             br.close();
             fr.close(); 
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
   
   
  /*
     Method toString: returns all the attributes of the drink in a String
  */
  public String toString(File address)throws IOException
  {
  
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //Creates a new BufferedReader
     BufferedReader br= new BufferedReader(fr);
     String line;
     
          
      
     while ((line= br.readLine())!=null){
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i < 81 ; i++) {
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             
             //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
             if (words [0]=="Ant"){
             
                  this.abilityName="Faint: Give 1 random (+2/+1)/(+4/+2)/(+6/+3)";
                  
                  
             }else if (words [0]=="Beaver"){
             
                  this.abilityName="Faint: Give 1 random (+2/+1)/(+4/+2)/(+6/+3)";
             
             }
             else if (words [0]=="Cricket"){
             
                  this.abilityName="Faint: Summon  (1/1)/(2/2)/(3/3) Cricket";
             
             }
             else if (words [0]== "Duck"){
             
                  this.abilityName="Sell: Give shop pets +1/+2/+3 HP";
             }
             else if (words [0]=="Fish"){
             
                  this.abilityName="Level-up: Give 5 friends (+1/+1)/(+2/+2)";
             }
             else if (words [0]=="Horse"){
                  this.abilityName="Friend summoned: Give it +1/+2/+3 ATK until the end of battle";
             
             }
             else if (words [0]=="Mosquito"){
             
                  this.abilityName="Start of battle: Deal 1 dmg to 1/2/3 random enemies";
             }
             else if (words [0]=="Otter"){
             
                  this.abilityName="Buy: Give a random friend (+1/+1)/(+2/+2)/(+3/+3)";
             }
             else if (words [0]=="Pig"){
             
                  this.abilityName="Sell: Gain 1/2/3 gold";
             
             }
             else if (words [0]=="Sloth"){
             
                  this.abilityName="Sloth has no special ability. Is kind of lame combat-wise. But he truly believes in you!)";
             
             }else {
             
                 this.abilityName=this.abilityName;
             
             }
             
             
         } 
         
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close();
     return ("|name:"+(this.name)+"|health:"+ (this.health)+"|direct Attack:"+(this.directAttack)+"|level :"+(this.level)+ "|tier"+(this.tier)+"|ability:"+(this.abilityName));
   }
     
     
     
     
 public String [] abilityActivate (String name,File address)throws IOException
 {
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //Creates a new BufferedReader
     BufferedReader br= new BufferedReader(fr);
     String line;
     
          
      
     while ((line= br.readLine())!=null){
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i < 81 ; i++) {
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             int randomAnimal;  
             int randomAnimal2;
             int randomAnimal3;
             int randomAnimal4;
             int randomAnimal5;
             
             String randomAnimalStr;
           
             //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
             
             
             //ant ability activate
             if (words [0]=="Ant"){
             
                  randomAnimal=randomNumberGenerator(1, 5);
                  randomAnimal2=randomNumberGenerator(1, 5);
                  randomAnimal3=randomNumberGenerator(1, 5);
                  randomAnimal4=randomNumberGenerator(1, 5);
                  randomAnimal5=randomNumberGenerator(1, 5);
                  randomAnimalStr=""+randomAnimal;
                  randomAnimalStr=""+randomAnimal+","+randomAnimal2+","+randomAnimal3+","+randomAnimal4+","+randomAnimal5;

                  
                  if (this.level==1){
                     

                     String[] antAbility= {"F","a2","h1",randomAnimalStr};
                     return  antAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] antAbility={"F","a4","h2",randomAnimalStr};
                     return  antAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] antAbility={"F","a6","h3",randomAnimalStr};
                     return  antAbility ;

                  }else {
                  
                     return null;
                  }
                 
             //beaver ability activate  
             }else if (words [0]=="Beaver"){
                  randomAnimal=randomNumberGenerator(1, 5);
                  randomAnimal2=randomNumberGenerator(1, 5);
  

                  randomAnimalStr=""+randomAnimal+","+randomAnimal2;
                  if (this.level==1){
                     

                     String[] beaverAbility= {"S","h1",randomAnimalStr};
                     return  beaverAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] beaverAbility={"S","h2",randomAnimalStr};
                     return  beaverAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] beaverAbility={"S","h3",randomAnimalStr};
                     return  beaverAbility ;

                  }else {
                  
                     return null;
                  }
             
                          
             }
             //Cricket ability activate
             else if (words [0]=="Cricket"){
             
                  if (this.level==1){
                     

                     String[] cricketAbility= {"S","a1","h1"};
                     return  cricketAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] cricketAbility={"S","a2","h2"};
                     return  cricketAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] cricketAbility={"S","a3","h3"};
                     return  cricketAbility ;

                  }else {
                  
                     return null;
                  }
             
             }
             
             
             //Duck ability activate
             else if (words [0]== "Duck"){
                  if (this.level==1){
                     

                     String[] duckAbility= {"S","h1"};
                     return  duckAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] duckAbility={"S","h2"};
                     return  duckAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] duckAbility={"S","h3"};
                     return  duckAbility ;

                  }else {
                  
                     return null;
                  }
             }
             //Fish ability activate 
             else if (words [0]=="Fish"){
                  
                  if (this.level==1){
                     

                     String[] fishAbility= {"L","a1","h1","5"};
                     return  fishAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] fishAbility={"L","a2","h2","5"};
                     return  fishAbility ;

                  }else {
                  
                     return null;
                  }
             
             }
             //Horse ability activate
             else if (words [0]=="Horse"){
                  //"Friend summoned: Give it +1/+2/+3 ATK until the end of battle";
                  if (this.level==1){
                     

                     String[] horseAbility= {"FS","a3","h1"};
                     return  horseAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] horseAbility={"FS","a3","h2"};
                     return  horseAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] horseAbility={"FS","a3","h3"};
                     return  horseAbility ;

                  }else {
                  
                     return null;
                  }
             //activate Mosquito ability
             }
             else if (words [0]=="Mosquito"){
                  randomAnimal=randomNumberGenerator(1, 5);
                  randomAnimal2=randomNumberGenerator(1, 5);
                  randomAnimal3=randomNumberGenerator(1, 5);
                  if (this.level==1){
                     
                     randomAnimalStr=""+randomAnimal;
                     String[] mosquitoAbility= {"SB","a1",randomAnimalStr};
                     return  mosquitoAbility ;
                     
                  }else if (this.level==2){
                  
                     randomAnimalStr=""+randomAnimal+","+randomAnimal2;
                     String[] mosquitoAbility={"SB","a1",randomAnimalStr};
                     randomAnimalStr=""+randomAnimal+","+randomAnimal2;return  mosquitoAbility ;

                     
                  }else if (this.level==3){
                  
                     randomAnimalStr=""+randomAnimal+","+randomAnimal2+","+randomAnimal3;
                     String[] mosquitoAbility={"SB","a1",randomAnimalStr};
                     return  mosquitoAbility ;
    

                  }else {
                  
                     return null;
                  }

             }
             //activate Otter ability
             else if (words [0]=="Otter"){
                  randomAnimal=randomNumberGenerator(1, 5);
  

                  randomAnimalStr=""+randomAnimal;
                  if (this.level==1){
                     

                     String[] otterAbility= {"B","a1","h1",randomAnimalStr};
                     return  otterAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] otterAbility={"B","a2","h2",randomAnimalStr};
                     return  otterAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] otterAbility={"B","a3","h3",randomAnimalStr};
                     return  otterAbility ;

                  }else {
                  
                     return null;
       
                  }
             
             }
             //activate pig ability 
             else if (words [0]=="Pig"){
                  if (this.level==1){
                     

                     String[] pigAbility= {"S","g1"};
                     return  pigAbility ;
                     
                  }else if (this.level==2){
                  
                     String[] pigAbility={"S","g2"};
                     return  pigAbility ;

                     
                  }else if (this.level==3){
                  
                     String[] pigAbility={"S","g3"};
                     return  pigAbility ;
                 

                  }else {
                  
                     return null;
                  }
                          
             }
             //activate Sloth ability
             else if (words [0]=="Sloth"){
                  return null;
             
             }else {
             
                  return null;
             }
             
             
         }    
      
     }
     //closing the FileReader and bufferedReader
     br.close();
     fr.close();
     return null;
   }
     

}
