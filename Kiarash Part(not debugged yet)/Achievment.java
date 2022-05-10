/**
* Name: Kiarash Kianidehkordi
* Date: April 1st 2022
* Description: The Achievment class allows the player to access his/her achievments using the methods inside the class, it reads the achievment from the text file that is constantly rewritten by the lobby class
*/

import java.io.File;
import java. util. Arrays;
import java.io.FileReader;
import java.io.BufferedReader; 
import java.io.IOException;

public class Achievment {
   /** Achievment name */
   private String name;
   
   /** Attirbute that indicate wether an achievment is earned or not  */
   private boolean earned;
   /**Attirbute that indicate wether an achievment has a ribbon or not */
   private boolean ribbon;
   public Achievment () {
      this.name = "";
      this.earned=false;
      this.ribbon=false;
   }
   /**
   Create an achievment 
   @param name
   @param earned
   @param ribbon
   */
   public Achievment (String name,boolean earned,boolean ribbon) {
      this.name = name;
      this.earned=earned;
      this.ribbon=ribbon;
            
      // Restricting 
      if (earned==true) {
         this.earned = false;
      } else {
         this.earned = earned;
      }
       if (ribbon==true) {
         this.ribbon = false;
      } else {
         this.ribbon = ribbon;
      }
   }
   
   /*
   Accessors
   */
      
   /**
   gets the Achievment name
   @return the name of the acheivment
   */
   public String getName() {
      return this.name;
   }
   /**
   gets wether the player has earned this achievment or not
   @return the boolean that indicates the ownership of an achievment
   */
   public boolean getEarned () {
      return this.earned;
   }
      
   /**
   gets wether the achievment has ribbon or not
   @return the direct attack
   */
   public boolean getRibbon () {
      return this.ribbon;
   }
   
   public  void getAchievments (File address, String achievmentName)throws IOException
   
   {
     //Create a new filereader which allows the main to call it using the file address containing the animal informations 
     FileReader fr= new FileReader(address);
     //
     BufferedReader br= new BufferedReader(fr);
     //
     String line; 
     while ((line= br.readLine())!=null)
     {
      
         //first loop, check for all the words inside the sentence
         for (int i = 0; i < 81 ; i++)
         {
             String [] words = line.split(","); //spliting the sentence into words and saving it inside an array
             //change the attirbutes of the animal asked for by reading the textfile that contains the info of each animal and finding the line that contains it
               if (words [0]==name){
                  this.name= words[0];
               }
               //casting the String version of attirbutes saved on the text file into int so it can be manipulated by other classes and methods
               if ((Integer.parseInt(words[6]))==1)
               {
                  this.earned=true ;
               }else {
                  this.earned=false;
               }
               
               if ((Integer.parseInt(words[7]))==1)
               {
                  this.ribbon=ribbon ;
               }else 
               {
                  this.ribbon=ribbon;
               }
         }
    }
  }    

}