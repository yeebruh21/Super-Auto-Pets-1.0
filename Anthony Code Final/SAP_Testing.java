/**
* Name: Anthony
* Date: May 5, 2022
* Description: Tests the most important functionality of the super auto pets program.
**/

import java.io.*;
import java.util.*;

public class SAP_Testing {
   public static void main(String[] args) {
      String user = "yeebruh21";
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
      Hat hats[] = new Hat[31];
      Game[] recentGames = new Game[10];
      int petsArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int foodArr[] = {11, 12, 13};
      boolean backgroundArr[] = {true, true, false, false, false, false, false};
      boolean hatsArr[] = {true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
      Profile example = new Profile("yeebruh21", "bruhbruh", "achen3741@gmail.com", 3, 1, 12, 70, petsArr, "Ant", "Duck", foodArr, "Apple", "Honey", 0, false, hatsArr, backgroundArr, "Top Hat", "Grass Field");
      History historyPage = new History(user);
      Background backgroundPage = new Background();
      
      try {
         // Allowing user to access information
         int input = 0;
         Scanner sc = new Scanner(System.in);
         while (input != 9) {
            System.out.println("What would you like to access?");
            System.out.println("1: Basic user information");
            System.out.println("2: History");
            System.out.println("3: Game stats");
            System.out.println("4: Pet/Food stats");
            System.out.println("5: Hats page");
            System.out.println("6: Backgrounds page");
            System.out.println("7: Play game");
            System.out.println("8: Achievements page");
            System.out.println("9: None (Exit)");
            input = Integer.parseInt(sc.nextLine());
         
            switch(input) {
               case 1:
                  System.out.println("Username: " + example.getUser());
                  System.out.println("Email: " + example.getEmail() + "\n");
                  break;
               case 2: 
                  recentGames = historyPage.getRecentGames();
                  if (example.getMatchesPlayed() < 10) {
                     for (int i = 0; i < example.getMatchesPlayed(); i++) {
                        System.out.println(recentGames[i].toString());
                     }
                  }
                  else {
                     for (int i = 0; i < recentGames.length; i++) {
                        System.out.println(recentGames[i].toString());
                     }
                  }
                  break;
               case 3:
                  System.out.println("Matches Played: " + example.getMatchesPlayed());
                  System.out.println("Matches Won: " + example.getMatchesWon());
                  System.out.println("Trophies Won: " + example.getTrophiesWon());
                  System.out.println("Total points earned: " + example.getPoints() + "\n");
                  break;
               case 4:
                  int mostPet = 0;
                  int mostPetRecord = 0;
                  int leastPet = 999999;
                  int leastPetRecord = 0;
                  for (int i = 0; i < 10; i++) {
                     if (mostPet < petsArr[i]) {
                        mostPet = petsArr[i];
                        mostPetRecord = i;
                     }
                     if (leastPet > petsArr[i]) {
                        leastPet = petsArr[i];
                        leastPetRecord = i;
                     }
                  }
                  System.out.println(mostPetRecord);
                  System.out.println(leastPetRecord);
                  System.out.println("Most frequent pet: " + animals[mostPetRecord].getName());
                  System.out.println("Least frequent pet: " + animals[leastPetRecord].getName());
                  System.out.println("Most frequent food: " + example.getMostFood());
                  System.out.println("Least frequent food: " + example.getLeastFood() + "\n");
                  break;
               case 5: 
                  File f = new File(user + "_Hats.txt");
                  FileReader fr = new FileReader(f);
                  BufferedReader br = new BufferedReader(fr);
                  String line;
               
                  for (int i = 0; i < 31; i++) {
                     String hatName = "";
                     String hatType = "";
                     int hatCoinPrice = 0;
                     double hatMoneyPrice = 0;
                     boolean hatOwned = false;
                     boolean hatActive = false;
                     boolean hatSpecial = false;
                     
                     line = br.readLine();
                     hatName = line;
                     line = br.readLine();
                     hatType = line;
                     line = br.readLine();
                     hatCoinPrice = Integer.parseInt(line);
                     line = br.readLine();
                     hatMoneyPrice = Double.parseDouble(line);
                     line = br.readLine();
                     hatOwned = Boolean.parseBoolean(line);
                     line = br.readLine();
                     hatActive = Boolean.parseBoolean(line);
                     line = br.readLine();
                     hatSpecial = Boolean.parseBoolean(line);
                     
                     hats[i] = new Hat(hatName, hatType, hatCoinPrice, hatMoneyPrice, hatOwned, hatActive, hatSpecial);
                  }
                  
                  fr.close();
                  br.close();
                  
                  for (int i = 0; i < hats.length; i++) {
                     System.out.println(hats[i].getName());
                     if (hats[i].getOwned() == true) {
                        if (hats[i].getActive() == true) {
                           System.out.println("Active");
                        }
                        else {
                           System.out.println("Owned");
                        }  
                     }
                     else {
                        if (hats[i].getSpecial() == true && hats[i].getMoneyPrice() > 0) {
                           System.out.println("Price - $" + hats[i].getMoneyPrice());
                        }
                        else if (hats[i].getSpecial() == false) {
                           System.out.println("Price - " + hats[i].getCoinPrice() + " coins");
                        }
                     }
                     System.out.println("\n");
                  }
                  
                  String hatSelect = "";
                  String buySelect = "";
                  boolean validTrigger = false;
                  
                  System.out.println("Would you like to select a new active hat?");
                  hatSelect = sc.nextLine();
                  if (hatSelect.equals("yes") || hatSelect.equals("y") || hatSelect.equals("Y")) {
                     System.out.println("\nEnter the hat you would like to choose as active: ");
                     hatSelect = sc.nextLine();
                     for (int j = 0; j < hats.length; j++) {
                        if (hats[j].getName().equals(hatSelect)) {
                           if (hats[j].getOwned() == true && hats[j].getActive() == false) {
                              for (int k = 0; k < hats.length; k++) {
                                 if (hats[k].getActive() == true) {
                                    hats[k].setActive(false);
                                 }
                              }
                              hats[j].setActive(true);
                              example.updateEquippedHat(hatSelect);
                              
                              FileWriter fw = new FileWriter(f);
                              BufferedWriter bw = new BufferedWriter(fw);
                              
                              // Updating player hat file
                              for (int l = 0; l < hats.length; l++) {
                                 bw.write(hats[l].getName() + "\n");
                                 bw.write(hats[l].getHatType() + "\n");
                                 bw.write(hats[l].getCoinPrice() + "\n");
                                 bw.write(String.valueOf(hats[l].getMoneyPrice()) + "\n");
                                 bw.write(String.valueOf(hats[l].getOwned()) + "\n");
                                 bw.write(String.valueOf(hats[l].getActive()) + "\n");
                                 bw.write(String.valueOf(hats[l].getSpecial() + "\n"));
                              }
                              bw.close();
                              
                              System.out.println("Hat switched successfully!\n");
                           }
                           else if (hats[j].getOwned() == true && hats[j].getActive() == true) {
                              System.out.println("Hat already active!\n");
                           }
                           else {
                              System.out.println("Hat isn't owned.\n");
                           }
                           validTrigger = true;
                        }
                     }
                     if (validTrigger == false) {
                        System.out.println("Invalid hat chosen. Try again.");
                     }
                  }
                  
                  System.out.println("Would you like to buy any hats?");
                  buySelect = sc.nextLine();
                  if (buySelect.equals("yes") || buySelect.equals("y") || buySelect.equals("Y")) {
                     
                  }
                  
                  break;
               
               case 6: 
                  System.out.println(backgroundPage.toString());
                  // NOTE: Background class needs to be fixed
                  
                  break;
               case 7:
                  // NOTE: PLAY FUNCTION WILL BE DEMONSTRATED BY SHUHAN
                  break;
               case 8: 
                  // NOTE: ACHIEVEMENT TEXT FILE MISSING
                  break;
               default: 
                  break;
            }
         }
      }
      catch (IOException e) {
         System.out.println("Input-output error.");
      }
      
   }
}