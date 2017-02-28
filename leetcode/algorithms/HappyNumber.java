package algorithms;

import java.util.Hashtable;

public class HappyNumber {
	public boolean isHappy(int n) {
        int sum = n;
        Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean>();
        while (sum != 1){
            sum = sumOfSquareOfDigits(sum);
            if (ht.containsKey(sum)){
                return false;
            }
            ht.put(sum, true);
        }
        return true;
    }
	public int sumOfSquareOfDigits(int n) {
		int sum = 0;
		int digit;
		while(n>0){
			digit = n%10;
			n = n/10;
			sum += digit*digit;
		}
		return sum;
	}
	
}

