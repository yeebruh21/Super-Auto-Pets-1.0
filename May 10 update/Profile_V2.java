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
   
   /** equipped hat */
   private String equippedHat;
   
   /** equipped background */
   private String equippedBackground;
   
   Animal Ant = new Animal("Ant", 1, 2, 1, 1, "Faint: Give a random friend (+2/+1).");
   Animal Beaver = new Animal("Beaver", 2, 2, 1, 1, "Sell: Give 2 random friends +1 HP.");
   Animal Cricket = new Animal("Cricket", 2, 1, 1, 1, "Faint: Summon a (1/1) Zombie Cricket.");
   Animal Duck = new Animal("Duck", 3, 1, 1, 1, "Sell: Give shop pets +1 HP.");
   Animal Fish = new Animal("Fish", 3, 2, 1, 1, "Level-up: Give all friends (+1/+1).");
   Animal Horse = new Animal("Horse", 1, 2, 1, 1, "Friends summoned: Give it +1 ATK until the end of battle.");
   Animal Mosquito = new Animal("Mosquito", 2, 2, 1, 1, "Start of battle: Deal 1 dmg to 1 random enemy.");
   Animal Otter = new Animal("Otter", 2, 1, 1, 1, "Buy: Give a random friend (+1/+1).");
   Animal Pig = new Animal("Pig", 1, 3, 1, 1, "Sell: Gain 1 gold.");
   Animal Sloth = new Animal("Sloth", 1, 1, 1, 1, "Sloth has no special ability. Is kind of lame combat-wise. But he truly believes in you!");
   Animal animals[] = {Ant, Beaver, Cricket, Duck, Fish, Horse, Mosquito, Otter, Pig, Sloth};
   
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
   
   public Profile (String username, String password, String email, int matchesPlayed, int matchesWon, int trophiesWon, int points, int[] petUsed, String mostPet, String leastPet, int[] foodUsed, String mostFood, String leastFood, int abandonCount, boolean restricted, boolean[] ownedHats, boolean[] ownedBackgrounds, String equippedHat, String equippedBackground) {
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
            this.equippedHat = "None";
            this.equippedBackground = "None";
            
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
               this.equippedHat = equippedHat;
               this.equippedBackground = equippedBackground;
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
               line = br.readLine();
               this.equippedHat = line;
               line = br.readLine();
               this.equippedBackground = line;
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
      return this.username;
   }
   
   /** gets the email of the profile 
   @return the profile email
   */
   public String getEmail() {
      return this.email;
   }
   
   /** gets the number of matches played 
   @return total matches number
   */
   public int getMatchesPlayed() {
      return this.matchesPlayed;
   }
   
   /** gets the number of matches won 
   @return total win number
   */
   public int getMatchesWon() {
      return this.matchesWon;
   }
   
   /** gets the number of trophies won 
   @return total trophy count
   */
   public int getTrophiesWon() {
      return this.trophiesWon;
   }
   
   /** gets the number of points earned 
   @return total points earned
   */
   public int getPoints() {
      return this.points;
   }
   
   /** gets the count of how many times each pet has been used 
   @return how frequently each pet used in array
   */
   public int[] getPetUsed() {
      return this.petUsed;
   }
   
   /** gets the pet used most often 
   @return most used pet
   */
   public String getMostPet() {
      return this.mostPet;
   }
   
   /** gets the pet used least often 
   @return least used pet
   */
   public String getLeastPet() {
      return this.leastPet;
   }
   
   /** gets the count of how many times each food has been used 
   @return how frequently each food used in array
   */
   public int[] getFoodUsed() {
      return this.foodUsed;
   }
   
   /** gets the food used most often
   @return the most used food
   */
   public String getMostFood() {
      return this.mostFood;
   }
   
   /** gets the food used least often
   @return the least used food
   */
   public String getLeastFood() {
      return this.leastFood;
   }
   
   /** gets the count of times user has abandoned games in a row
   @return the abandon count
   */
   public int getAbandonCount() {
      return this.abandonCount;
   }
   
   /** gets whether user has been restricted yet
   @return whether user is restricted
   */
   public boolean getRestricted() {
      return this.restricted;
   }
   
   /** gets value for each hat available and whether user owns it
   @return all hats and boolean values for user ownership
   */
   public boolean[] getOwnedHats() {
      return this.ownedHats;
   }
   
   /** gets value for each background and whether owned
   @return all backgrounds and boolean values for user ownership
   */
   public boolean[] getOwnedBackgrounds() {
      return this.ownedBackgrounds;
   }
   
   /** gets equipped hat
   @return name of hat that user has equipped
   */
   public String getEquippedHat() {
      return this.equippedHat;
   }
   
   /** gets equipped background 
   @return name of equipped background
   */
   public String getEquippedBackground() {
      return this.equippedBackground;
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
   
   /** updates the pets count array
   @param array of times each pet was used
   */
   public void updatePetUsed(int[] petsCount) {
      for (int i = 0; i < petUsed.length; i++) {
         petUsed[i] += petsCount[i];
      }
      
      int p1 = 0;
      int record1 = 0;
      int p2 = 999999;
      int record2 = 0;
      for (int i = 0; i < 10; i++) {
         if (p1 < petUsed[i]) {
            p1 = petUsed[i];
            record1 = i;
            mostPet = animals[i].getName();
         }
         if (p2 > petUsed[i]) {
            p2 = petUsed[i];
            record2 = i;
            leastPet = animals[i].getName();
         }
      }
   }
   
   /** updates the food count array
   @param array of times each food was used in most recent game
   */
   public void updateFoodUsed(int[] foodCount) {
      //NOTE: CONTINUE ONCE FOOD CLASS COMPLETE
   }
   
   /** updates the equipped hat
   @param name of hat that user's chosen to equip
   */
   public void updateEquippedHat(String hatName) {
      this.equippedHat = hatName;
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
}