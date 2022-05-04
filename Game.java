/**
* Name: Anthony
* Date: May 2, 2022
* Description: Creates game object with various relevant attributes and getter methods to retrieve data.
**/

public class Game {
   
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
   Default game creation
   */
   public Game() {
      this.playerOne = "Player 1";
      this.playerTwo = "Player 2";
      this.trophies = 0;
      this.lives = 10;
      this.turn = 1;
      this.name = "";
      this.date = "";
   }
   
   /** 
   Creates a game object
   @param playerOne
   @param playerTwo
   @param trophies
   @param lives
   @param turn
   @param name
   @param data
   */
   
   public Game(String playerOne, String playerTwo, int trophies, int lives, int turn, String name, String date) {
      this.playerOne = playerOne;
      this.playerTwo = playerTwo;
      this.name = name;
      this.date = date;
      
      // Restricting user access to trophies
      if (trophies < 0) {
         this.trophies = 0;
      }
      else if (trophies > 10) {
         this.trophies = 10;
      }
      else {
         this.trophies = trophies;
      }
      
      // Restricting user access to turn
      if (turn <= 0) {
         this.turn = 1;
      }
      else {
         this.turn = turn;
      }
      
      // Restricting user access to lives
      if (lives <= 0) {
         this.lives = 0;
      }
      else if (lives > 10) {
         this.lives = 10;
      }
      else {
         this.lives = lives;
      }
      
      // NOTE: INCLUDE PLAYER AND TEAM LATER
   }
   
   /*
   Accessors
   */
   
   /** gets the team name for the game
   @return the name of the team
   */
   public String getName() {
      return this.name;
   }
   
   /** gets the date of the game
   @return the game date
   */
   public String getDate() {
      return this.date;
   }
   
   /** gets the number of trophies
   @return the trophies earned in the game
   */
   public int getTrophies() {
      return this.trophies;
   }
   
   /** gets the turn number
   @return the turn number of the game
   */
   public int getTurn() {
      return this.turn;
   }
   
   /** gets the number of lives left
   @return number of lives remaining
   */
   public int getLives() {
      return this.lives;
   }
   
   /** returns all information about game
   @return all attributes of the game in a string
   */
   public String toString() {
      return ("Player 1: " + playerOne + "\nPlayer 2: " + playerTwo + "\nTrophies: " + trophies + "\nLives: " + lives + "\nTurn: " + turn + "\nTeam Name: " + name + "\nDate: " + date + "\n");
   }  
}
