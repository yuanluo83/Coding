package com.leetcode.oj.algorithms;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        int i = 0;
        int seq = 0;
        while (k!=0 && i<=n){
            if (i == n){
                if(n == 1){
                    return String.valueOf(1);
                }
                return String.valueOf(seq * 10 + k);
            }
            seq = seq*10 + k / (n-i);
            k = k % (n-i);
            i++;
        }
        if (i<n){
            for (int j = 1; j<=n-i ; j++){
                seq = seq * 10 + j;
            }
        }
        return String.valueOf(seq);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(2,1));
	}

}
