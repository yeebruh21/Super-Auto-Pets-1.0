/**
* Name: Anthony
* Date: April 28, 2022
* Description: Creates hat class that defines a pet hat using multiple attributes. Also defines getter
* methods that can retrieve data about certain variables. 
**/

public class Hat {
   /** name of hat */
   private String name;

   /** exclusivity of hat */
   private String hatType;
   
   /** price of hat in in-game coins */
   private int coinPrice;
   
   /** price of hat in real money */
   private double moneyPrice;
   
   /** whether player owns the hat or not */
   private boolean owned;
   
   /** whether hat is active or not */
   private boolean active;
   
   /** whether hat is a special hat or not */
   private boolean special;
   
   /** 
   Default hat creation
   */
   public Hat() {
      this.name = "";
      this.hatType = "standard";
      this.coinPrice = 0;
      this.moneyPrice = 0;
      this.owned = false;
      this.active = false;
      this.special = false;
   }
   
   /**
   Creates hat object
   @param name
   @param hatType
   @param coinPrice
   @param moneyPrice
   @param owned
   @param active
   @param special
   */
   public Hat(String name, String hatType, int coinPrice, double moneyPrice, boolean owned, boolean active, boolean special) {
      this.name = name;
      this.owned = owned;
      this.active = active;
      this.special = special;
      
      // Restricting user access to type of hat
      if (!(hatType.equals("standard") || hatType.equals("expansionOne"))) {
         this.hatType = "standard";
      }
      else {
         this.hatType = hatType;
      }
      
      // Restricting user access to price of hat in in-game coins
      if (coinPrice <= 0) {
         coinPrice = 100;
      }
      
      // Restricting user access to price of hat in real money
      if (moneyPrice <= 0) {
         moneyPrice = 0;
      }
   }
   
   /*
   Accessors
   */
   
   /** gets the hat name 
   @return the name of the hat
   */
   public String getName() {
      return this.name;
   }
   
   /** gets the type of hat
   @return the exclusivity of the hat
   */
   public String getHatType() {
      return this.hatType;
   }
   
   /** gets the price of the hat in-game
   @return the price of the hat in coins
   */
   public int getCoinPrice() {
      return this.coinPrice;
   }
   
   /** gets the price of the hat in real life
   @return the price of the hat in CAD$
   */
   public Double getMoneyPrice() {
      return this.moneyPrice;
   }
   
   /** gets whether the player owns the hat
   @return the boolean value for whether hat is owned
   */
   public boolean getOwned() {
      return this.owned;
   }
   
   /** gets whether the hat is currently being used
   @return the boolean value for whether the hat is active
   */
   public boolean getActive() {
      return this.active;
   }
   
   /** gets whether the hat is unique 
   @return the boolean value for whether the hat is special
   */
   public boolean getSpecial() {
      return this.special;
   }
   
   /** returns the most important information regarding the hat
   @return all attributs of the hat in a string
   */
   public String toString() {
      return ("Name: " + this.name + "\nPack: " + this.hatType + "\nIn-game price: " + this.coinPrice + " coins\nReal price: $" + this.moneyPrice + "\nOwned: " + this.owned + "\nActive: " + this.active + "\nSpecial: " + this.special + "\n");
   }
}

