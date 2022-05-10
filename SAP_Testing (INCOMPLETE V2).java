//TESTING CLASS

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
      Game[] recentGames = new Game[10];
      int petsArr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      int foodArr[] = {11, 12, 13};
      boolean backgroundArr[] = {true, true, false, false, false, false, false};
      boolean hatsArr[] = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
      Profile example = new Profile("yeebruh21", "bruhbruh", "achen3741@gmail.com", 100, 10, 2000, 2500, petsArr, "Ant", "Duck", foodArr, "Apple", "Honey", 0, false, hatsArr, backgroundArr, "Top Hat", "Grass Field");
      History historyPage = new History(user);
      
      // Allowing user to access information
      int input = 0;
      Scanner sc = new Scanner(System.in);
      while (input != 7) {
         System.out.println("What would you like to access?");
         System.out.println("1: Basic user information");
         System.out.println("2: History");
         System.out.println("3: Game stats");
         System.out.println("4: Pet/Food stats");
         System.out.println("5: Hats page");
         System.out.println("6: Backgrounds page");
         System.out.println("7: None (Exit)");
         input = Integer.parseInt(sc.nextLine());
         
         switch(input) {
            case 1:
               System.out.println("Username: " + example.getUser());
               System.out.println("Email: " + example.getEmail());
               break;
            case 2: 
               recentGames = historyPage.getRecentGames();
               for (int i = 0; i < 2; i++) {
                  System.out.println(recentGames[i].toString());
               }
               break;
            case 3:
               System.out.println("Matches Played: " + example.getMatchesPlayed());
               System.out.println("Matches Won: " + example.getMatchesWon());
               System.out.println("Trophies Won: " + example.getTrophiesWon());
               System.out.println("Total points earned: " + example.getPoints());
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
               System.out.println("Most frequent pet: " + animals[mostPetRecord]);
               System.out.println("Least frequent pet: " + animals[leastPetRecord]);
               System.out.println("Most frequent food: " + example.getMostFood());
               System.out.println("Least frequent food: " + example.getLeastFood());
               break;
            case 4:
               break;
            case 5: 
               break;
            case 6: 
               break;
            default: 
               break;
         }
      }
      
   }
}