/**
* Name: Anthony
* Date: May 3, 2022
* Description: Creates history class that records most recent ten games played and won by user. 
**/

import java.io.*;

public class History {
   
   /** username of player */
   private String user;
   
   /** array filled with most recent games */
   private Game[] recentGames = new Game[10];
   
   /** array with most recent wins */
   private Game[] recentWins = new Game[10];
   
   /** username of first player */
   private String playerOne;
   
   /** username of second player */
   private String playerTwo;
   
   /** number of trophies */
   private int trophies;
   
   /** number of lives left */
   private int lives;
   
   /** turn number */
   private int turn;
   
   /** name of team */
   private String name;
   
   /** date that game was concluded */
   private String date;
   
   /**
   Creates an instance of player history
   @param user
   */
   public History(String user) {
      File f = new File(user + "_History.txt");
      File g = new File(user + "_WinHistory.txt");
      int counter = 0;
      String line;
      
      try {
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         
         if (f.exists()) {
            line = br.readLine();
            
            while (line != null) {
               playerOne = line;
               line = br.readLine();
               playerTwo = line;
               line = br.readLine();
               trophies = Integer.parseInt(line);
               line = br.readLine();
               lives = Integer.parseInt(line);
               line = br.readLine();
               turn = Integer.parseInt(line);
               line = br.readLine();
               name = line;
               line = br.readLine();
               date = line;
               
               recentGames[counter] = new Game(playerOne, playerTwo, trophies, lives, turn, name, date);
               
               counter++;
               
               line = br.readLine();
            }
         }
         else {
            //write????
         }
         
         counter = 0;
         
         if (g.exists()) {
            line = br.readLine();
            
            while (line != null) {
               playerOne = line;
               line = br.readLine();
               playerTwo = line;
               line = br.readLine();
               trophies = Integer.parseInt(line);
               line = br.readLine();
               lives = Integer.parseInt(line);
               line = br.readLine();
               turn = Integer.parseInt(line);
               line = br.readLine();
               name = line;
               line = br.readLine();
               date = line;
               
               recentWins[counter] = new Game(playerOne, playerTwo, trophies, lives, turn, name, date);
               
               counter++;
               
               line = br.readLine();
            }
            fr.close();
            br.close();
         }
      }
      catch (IOException e) {
         System.out.println("Input-output error.");
      }
   }
   
   /*
   Accessors 
   */
   
   /** gets the most recent ten or less games of the user
   @return the array of recent games
   */
   public Game[] getRecentGames() {
      return recentGames;
   }
   
   /** gets the most recent ten or less wins of the user
   @return the array of recent wins
   */
   public Game[] getRecentWins() {
      return recentWins;
   }
}