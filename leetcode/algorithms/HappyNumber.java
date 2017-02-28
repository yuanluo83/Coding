/*
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1 
 */

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

