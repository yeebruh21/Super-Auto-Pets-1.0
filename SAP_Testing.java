//TESTING CLASS

public class SAP_Testing {
   public static void main(String[] args) {
      String user = "yeebruh21";
      Game[] recentGames = new Game[10];
      History historyPage = new History(user);
      
      recentGames = historyPage.getRecentGames();
      for (int i = 0; i < 2; i++) {
         System.out.println(recentGames[i].toString());
      }
   }
}