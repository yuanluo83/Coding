/*
 * 415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.


 */
package algorithms;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carrier = 0;
        int sizeNum1 = num1.length();
        int sizeNum2 = num2.length();
        int index = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (index<sizeNum1 && index<sizeNum2){
            int d1 = num1.charAt(sizeNum1-index-1) - '0';
            int d2 = num2.charAt(sizeNum2-index-1) - '0';
            System.out.println((d1 + d2 + carrier)%10);
            strBuilder.append((d1 + d2 + carrier)%10);
            carrier = (d1 + d2 + carrier)/10;
            index++;
        }
        while (index<sizeNum1){
            int d1 = num1.charAt(sizeNum1-index-1) - '0';
            strBuilder.append( (d1 + carrier)%10);
            carrier = (d1 + carrier)/10;
            index++;
        }
        while (index<sizeNum2){
            int d2 = num2.charAt(sizeNum2-index-1) - '0';
            strBuilder.append( (d2 + carrier)%10);
            carrier = (d2 + carrier)/10;
            index++;
        }
        if (carrier>0){
           strBuilder.append(carrier);
        }
        return strBuilder.reverse().toString();
    }
}