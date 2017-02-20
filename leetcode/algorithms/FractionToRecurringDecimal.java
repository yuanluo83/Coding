package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        String sign = "";
        	
        if (numerator < 0 == denominator < 0 || numerator == 0) {
        	sign = "";
        } else {
        	sign = "-";	
        }
        long lNumerator = Math.abs((long)numerator);
        long lDenominator = Math.abs((long)denominator);
        
        long c = lNumerator / lDenominator;
        long r = lNumerator % lDenominator;
        boolean infinite = true; 
        HashMap<Long, Integer> hMap = new HashMap<Long, Integer>(); 

        if (r==0) {
        	result = result + c;
        	infinite = false;
        }else {
        	result = result + c + ".";       
	        while (!hMap.containsKey(r) && infinite) {
	        	if (r != 0) {
	            	hMap.put(r, result.length());
	            }else {
	            	infinite = false;
	            	continue;
	            }
	            c = r * 10 / lDenominator;
	            r = r * 10 % lDenominator;
	            result = result + c;
	            
	        }
        }
        if (infinite) {
        	 int index = hMap.get(r);
        	 System.out.println(index);
             result = result.substring(0, index) + "(" + result.substring(index) + ")";
        }
       
        return sign+result;	

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1,-2147483648));
	}

}
