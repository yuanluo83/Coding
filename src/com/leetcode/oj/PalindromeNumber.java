package com.leetcode.oj;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        
        return (reverse(x)==x?true:false);
    }
    
    
    
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return 0;
        }
        boolean positive = (x>=0?true:false);
        int abs=(positive?x:(-1)*x);
        int rev=0;
        if (abs<10){
            return x;
        }
        while (abs/10>0){
            rev = rev+abs%10;
            if(rev>Integer.MAX_VALUE/10){
                return 0;
            }else if((rev==Integer.MAX_VALUE/10)&&((abs/10)%10>Integer.MAX_VALUE%10)){
                return 0;
            }
            rev=rev*10;
            abs=abs/10;
        }
        rev=rev+abs%10;
        
        return (positive?rev:(-1)*rev);
    }
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
