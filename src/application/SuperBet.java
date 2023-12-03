package application;

import java.util.List;

public class SuperBet extends Bet{
    private int luckyNumber;

    public SuperBet(int n1, int n2, int n3, int n4, int betMoney, int luckyN) {
        super(n1, n2, n3, n4, betMoney);
        this.luckyNumber = luckyN;

    }

    @Override
    public String toString() {
        return "lottery.SuperBet{" +
                "luckyNumber=" + luckyNumber +
                ", numbers=" + numbers +
                ", betMoney=" + betMoney +
                '}';
    }

    public int computeExtraGain(List<Integer> toloNumbers, int luckyNumber){
        int res = 0;
        res = computeGain(toloNumbers);
        if(res!= 0){
            if(this.luckyNumber == luckyNumber){
                res *= 5;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SuperBet sb1 = new SuperBet(1,2,3,4,10,7);
        System.out.println(sb1);
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

}
