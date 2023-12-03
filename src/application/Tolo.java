package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Tolo {
   private static int n = 0;

   private Integer id;
   private ArrayList<Bet> bets = new ArrayList<Bet>();
   private List<Integer> drawnNumbers;

   private int luckyNumber;
   public Tolo(List<Integer> drawnNumbers, int luckyNumber) throws InvalidIntervalException{
      try {
         if(checkNumbers(drawnNumbers) && checkLuckyNumber(luckyNumber)){
            n++;
            this.drawnNumbers = drawnNumbers;
            this.luckyNumber = luckyNumber;
            this.id = n;

         }


      }catch(InvalidIntervalException e){
         System.out.println(e.getMessage());

      }

   }
   public void createBet(int n1, int n2, int n3, int n4, int betMoney){
      Bet bet = new Bet(n1,n2,n3,n4, betMoney);
      bets.add(bet);

   }

   public void createBet(int n1, int n2, int n3, int n4,int luckyN, int betMoney) {
      Bet bet = new SuperBet(n1,n2,n3,n4, luckyN, betMoney);
      bets.add(bet);

   }

   public static boolean checkNumbers (List<Integer> drawnNumbers)throws InvalidIntervalException{
      if(!drawnNumbers.stream().allMatch(x -> x >= 1 && x <= 20)){
         throw new InvalidIntervalException("Numbers have to be between 1 and 20");
      }
      return true;
   }

   public boolean checkLuckyNumber(int luckyNumber) throws InvalidIntervalException{
      if(!(luckyNumber > 0 && luckyNumber < 11)){
         throw new InvalidIntervalException("Lucky number has to be between 1 and 10");
      }
      return true;
   }
   @Override
   public String toString() {
      return "Tolo{" +
              "id=" + id +
              ", bets=" + bets +
              ", drawnNumbers=" + drawnNumbers +
              ", luckyNumber=" + luckyNumber +
              '}';
   }

   public  int getN() {
      return n;
   }

   //This function is not prepared for multiple winners. We have to consider winners with
   // 3 numbers guessed. NEED TO BE DEVELOPED.
   public  List<Bet> computeWinner(){
      List<Bet> bets = new ArrayList<Bet>();
      bets = this.bets.stream().filter(b -> b.computeGain(this.drawnNumbers)>0).toList();
      return bets;
   }

   public List<Integer> getDrawnNumbers() {
      return drawnNumbers;
   }

   public int getLuckyNumber() {
      return luckyNumber;
   }

   public ArrayList<Bet> getBets() {
      return bets;
   }
   
  
   
   
}