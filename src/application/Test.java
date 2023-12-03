package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
	
	 public static Tolo createRandom() throws InvalidIntervalException {
		   Random rn = new Random();
		   List<Integer> numbers = new ArrayList<>();
		   for (int i = 0; i < 4; i++) {
			numbers.add(rn.nextInt(1, 20));
		   }
		   Integer luckyNumber = rn.nextInt(1, 10);
		   
		   return new Tolo(numbers, luckyNumber);
		   
		   //Tolo tolo = new Tolo();
	   }
	 
	 public static void main(String[] args) throws InvalidIntervalException {
		 System.out.println(createRandom().toString());
		 
	}
}
