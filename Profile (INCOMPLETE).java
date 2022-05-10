/**
*Name: Anthony
*Date: May 6, 2022
*Description: Creates an instance of a user profile. Retrieves and returns data to all other classes in 
* the game.
**/

import java.io.*;
import java.util.*;

public class Profile {
   
   /** username of profile */
   private String username;
   
   /** password of profile */
   private String password;
   
   /** email of user */
   private String email;
   
   /** total number of matches played */
   private int matchesPlayed;
   
   /** total number of matches won */
   private int matchesWon;
   
   /** total number of trophies won */
   private int trophiesWon;
   
   /** total number of points won */
   private int points;
   
   /** total number of times each animal has been used */
   private int[] petUsed = new int[10];
   
   /** most used pet */
   private String mostPet;
   
   /** least used pet */
   private String leastPet;
   
   /** total number of times each pet food has been used */
   private int[] foodUsed = new int[3];
   
   /** most used food */
   private String mostFood;
   
   /** least used food */
   private String leastFood;
   
   /** number of times user has abandoned game before completing one */
   private int abandonCount;
   
   /** whether user is currently wearing the abandon hat */
   private boolean restricted;
   
   /** list of all hats and whether user owns them */
   private boolean[] ownedHats = new boolean[26];
   
   /** list of all backgrounds and whether they are owned by user */
   private boolean[] ownedBackgrounds = new boolean[7];
   
   /** recent game history of user */
   private History userHistory;
   
   /**
   Creates instance of user profile
   @param username
   @param password
   @param email
   @param matchesPlayed
   @param matchesWon
   @param trophiesWon
   @param points
   @param petUsed
   @param mostPet
   @param leastPet
   @param foodUsed
   @param mostFood
   @param leastFood
   @param abandonCount
   @param restricted
   @param ownedHats
   @param ownedBackgrounds
   */
   
   public Profile (String username, String password, String email, int matchesPlayed, int matchesWon, int trophiesWon, int points, int[] petUsed, String mostPet, String leastPet, int[] foodUsed, String mostFood, String leastFood, int abandonCount, boolean restricted, boolean[] ownedHats, boolean[] ownedBackgrounds) {
      // Checking if profile exists and updating data if it does
      File user = new File (username + "_Info.txt");
      
      try {
         FileReader fr = new FileReader(user);
         BufferedReader br = new BufferedReader(fr);
         FileWriter fw = new FileWriter(user);
         String line;
         
         if (!user.exists()) {
            // Initiating user profile text file
         
            this.username = username;
            this.password = password;
            this.email = email;
            this.petUsed = petUsed;
            this.mostPet = mostPet;
            this.leastPet = leastPet;
            this.foodUsed = foodUsed;
            this.mostFood = mostFood;
            this.leastFood = leastFood;
            this.restricted = restricted;
            this.ownedHats = ownedHats;
            this.ownedBackgrounds = ownedBackgrounds;
            
            // Restricting user access to stats on matches
            if (matchesPlayed < 0) {
               this.matchesPlayed = 0;
            }
            else {
               this.matchesPlayed = matchesPlayed;
            }
            
            if (matchesWon < 0) {
               this.matchesWon = 0;
            }
            else {
               this.matchesWon = matchesWon;
            }
            
            if (trophiesWon < 0) {
               this.trophiesWon = 0;
            }
            else {
               this.trophiesWon = trophiesWon;
            }
            
            // Restricting user access to points
            if (points < 0) {
               this.points = 0;
            }
            else {
               this.points = points;
            }
            
            // Restricting user access to abandon count
            if (abandonCount < 0) {
               this.abandonCount = 0;
            }
            else {
               this.abandonCount = abandonCount;
            }
         }
         else {
            String input = "";
            Scanner sc = new Scanner(System.in);
            System.out.println("User " + username + " already exists. Would you like to update saved data?");
            input = sc.nextLine();
            if (input.equals("yes") || input.equals("y") || input.equals("Yes") || input.equals("Y")) {
               this.username = username;
               this.password = password;
               this.email = email;
               
               if (matchesPlayed < 0) {
                  this.matchesPlayed = 0;
               }
               else {
                  this.matchesPlayed = matchesPlayed;
               }
               
               if (matchesWon < 0) {
                  this.matchesWon = 0;
               }
               else {
                  this.matchesWon = matchesWon;
               }
               
               if (trophiesWon < 0) {
                  this.trophiesWon = 0;
               }
               else {
                  this.trophiesWon = trophiesWon;
               }
               
               if (points < 0) {
                  this.points = 0;
               }
               else {
                  this.points = points;
               }
               
               this.petUsed = petUsed;
               this.mostPet = mostPet;
               this.leastPet = leastPet;
               this.foodUsed = foodUsed;
               this.mostFood = mostFood;
               this.leastFood = leastFood;
               
               if (abandonCount < 0) {
                  this.abandonCount = 0;
               }
               else {
                  this.abandonCount = abandonCount;
               }
               
               this.restricted = restricted;
               this.ownedHats = ownedHats;
               this.ownedBackgrounds = ownedBackgrounds;
            }
            else {
               line = br.readLine();
               this.username = line;
               line = br.readLine();
               this.password = br.readLine();
               line = br.readLine();
               this.email = line;
               line = br.readLine();
               this.matchesPlayed = Integer.parseInt(line);
               line = br.readLine();
               this.matchesWon = Integer.parseInt(line);
               line = br.readLine();
               this.trophiesWon = Integer.parseInt(line);
               line = br.readLine();
               this.points = Integer.parseInt(line);
               line = br.readLine();
               String[] petNums = line.split(",");
               for (int i = 0; i < petNums.length; i++) {
                  petUsed[i] = Integer.parseInt(petNums[i]);
               }
               line = br.readLine();
               this.mostPet = line;
               line = br.readLine();
               this.leastPet = line;
               line = br.readLine();
               String[] foodNums = line.split(",");
               for (int j = 0; j < foodNums.length; j++) {
                  foodUsed[j] = Integer.parseInt(foodNums[j]);
               }
               line = br.readLine();
               this.mostFood = line;
               line = br.readLine();
               this.leastFood = line;
               line = br.readLine();
               this.abandonCount = Integer.parseInt(line);
               line = br.readLine();
               this.restricted = Boolean.parseBoolean(line);
               line = br.readLine();
               String hatsNum[] = line.split(",");
               for (int k = 0; k < hatsNum.length; k++) {
                  ownedHats[k] = Boolean.parseBoolean(hatsNum[k]);
               }  
               line = br.readLine();
               String bgNum[] = line.split(",");
               for (int l = 0; l < bgNum.length; l++) {
                  ownedBackgrounds[l] = Boolean.parseBoolean(bgNum[l]);
               }
            }
            
            fr.close();
            br.close();
         }
         
         //Initializing history class
         userHistory = new History(username);
         
      }
      catch (IOException e) {
         System.out.println("Input-output error.");
      } 
   }
   
   /*
   Accessors
   */
   
   /** gets the username of the profile 
   @return the profile username
   */
   public String getUser() {
      return username;
   }
   
   /** gets the email of the profile 
   @return the profile email
   */
   public String getEmail() {
      return email;
   }
   
   /** gets the number of matches played 
   @return total matches number
   */
   public int getMatchesPlayed() {
      return matchesPlayed;
   }
   
   /** gets the number of matches won 
   @return total win number
   */
   public int getMatchesWon() {
      return matchesWon;
   }
   
   /** gets the number of trophies won 
   @return total trophy count
   */
   public int getTrophiesWon() {
      return trophiesWon;
   }
   
   /** gets the number of points earned 
   @return total points earned
   */
   public int getPoints() {
      return points;
   }
   
   /** gets the count of how many times each pet has been used 
   @return how frequently each pet used in array
   */
   public int[] getPetUsed() {
      return petUsed;
   }
   
   /** gets the pet used most often 
   @return most used pet
   */
   public String getMostPet() {
      return mostPet;
   }
   
   /** gets the pet used least often 
   @return least used pet
   */
   public String getLeastPet() {
      return leastPet;
   }
   
   /** gets the count of how many times each food has been used 
   @return how frequently each food used in array
   */
   public int[] getFoodUsed() {
      return foodUsed;
   }
   
   /** gets the food used most often
   @return the most used food
   */
   public String getMostFood() {
      return mostFood;
   }
   
   /** gets the food used least often
   @return the least used food
   */
   public String getLeastFood() {
      return leastFood;
   }
   
   /** gets the count of times user has abandoned games in a row
   @return the abandon count
   */
   public int getAbandonCount() {
      return abandonCount;
   }
   
   /** gets whether user has been restricted yet
   @return whether user is restricted
   */
   public boolean getRestricted() {
      return restricted;
   }
   
   /** gets value for each hat available and whether user owns it
   @return all hats and boolean values for user ownership
   */
   public boolean[] getOwnedHats() {
      return ownedHats;
   }
   
   /** gets value for each background and whether owned
   @return all backgrounds and boolean values for user ownership
   */
   public boolean[] getOwnedBackgrounds() {
      return ownedBackgrounds;
   }
   
   /*
   Mutators
   */
   
   /** updates the password of the profile
   @param oldPass old user password
   */
   public void setPassword(String oldPass) {
      if (oldPass.equals(password)) {
         String firstInput = "";
         String secondInput = " ";
         Scanner sc = new Scanner(System.in);
         while (!firstInput.equals(secondInput)) {
            System.out.println("Enter your new password: ");
            firstInput = sc.nextLine();
            System.out.println("Re-enter this password: ");
            secondInput = sc.nextLine();
            
            if (firstInput.equals(secondInput)) {
               this.password = secondInput;
               System.out.println("New password successfully set!\n");
            }
            else {
               System.out.println("Passwords don't match. Try again!\n");
            }
         }
      }
      else {
         System.out.println("Password doesn't match records! Try again.");
      }
   }
   
   /** updates the email of the profile 
   @param newEmail new email that user wants to set
   */
   public void setEmail(String newEmail) {
      this.email = newEmail;
   }
   
   /** updates the number of matches played */
   public void updateMatches() {
      this.matchesPlayed++;
   }
   
   /** updates the number of matches won */
   public void updateWins() {
      this.matchesWon++;
   }
   
   /** updates the number of trophies won 
   @param trophiesEarned number of trophies gained in most recent game
   */
   public void updateTrophiesWon(int trophiesEarned) {
      this.trophiesWon += trophiesEarned;
   }
   
   /** updates the total number of points earned
   @param pointsEarned number of points earned in most recent game
   */
   public void updatePoints(int pointsEarned) {
      this.points += pointsEarned;
   }
   
   /** prints data of recent user game history */
   public void replay() {
      Game[] gameList = userHistory.getRecentGames();
      Game[] winList = userHistory.getRecentWins();
      System.out.println("Hall of Fame: ");
      for (int i = 0; i < gameList.length; i++) {
         System.out.println(gameList[i].toString());
      }
      System.out.println("Replays: ");
      for (int j = 0; j < winList.length; j++) {
         System.out.println(winList[j].toString());
      }
   }
   
   // NOTE: MISSING MUTATORS DUE TO CHANGES REQUIRED IN OTHER CLASSES 
   
   /** updates the count of times user has abandoned games in a row
   @param recentAbandon boolean value for whether user abandoned most recent game
   */
   public void updateAbandonCount(boolean recentAbandon) {
      if (recentAbandon == true) {
         this.abandonCount++;
         if (this.abandonCount >= 5) {
            this.restricted = true;
         }
      }
      else {
         this.abandonCount = 0;
         this.restricted = false;
      }
   }
   
   /** initiates the play function and updates all relevant variables after game has been completed or paused
   @param date date that game was started on
   */
   
   public void play(String date) {
      
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
      
      String [] teamNameArray = new String [3];
      int adjChoice, nounChoice; 
      String teamName = "";
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
      
      //store the name in the actual teamName object
      teamName = (teamNameArray[0]+" "+teamNameArray[1]+" "+teamNameArray[2]);
      
      // Creating instance of new team
      
      Team newTeam = new Team (0, 10, 0, teamName);
      
      //CONTINUE
   }
   
   
   
}