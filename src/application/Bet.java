package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bet {
    protected  List<Integer> numbers;
    protected  int betMoney;
    private static int n = 0;
    private int id;

    public Bet(int n1, int n2, int n3, int n4, int betMoney) {
        n++;
        this.numbers = List.of(n1,n2,n3,n4);
        this.betMoney = betMoney;
        this.id = n;
    }

    // We considered that that the user has to guess the numbers in order
    public int computeGain(List<Integer> toloNumbers){
        int points = 0;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            if(toloNumbers.get(i)==this.numbers.get(i)){
                points ++;
            }
        }
        if (points>2){
            if(points == 3 ){
                res =  this.betMoney*5;
            }
            else{
                res =  this.betMoney*50;
            }

        }

        return res;
    }

    @Override
    public String toString() {
        return "lottery.Bet{" +
                "numbers=" + numbers +
                ", betMoney=" + betMoney +
                '}';
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public static void main(String[] args) {
        Bet b1 = new Bet(1,2,3,4,10);
        System.out.println(b1);
    }

}
