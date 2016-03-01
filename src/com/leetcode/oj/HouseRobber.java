package com.leetcode.oj;

public class HouseRobber {
	/*
	 *  too slow, due to the duplicate calls in getRob. 
	 * 
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        } else {
            return getRob(nums, nums.length-1);
        }
    }
    
    public int getRob (int[] nums, int cursor){
        if (cursor==0){
            return nums[0];
        } else if (cursor==1){
            return getMax(nums[0], nums[1]);
        } else {
            return getMax(getRob(nums,cursor-2)+nums[cursor], getRob(nums,cursor-1));
        }
    }
    */
	
	// This implementation is way faster. O(n).
    public int rob(int[] nums) {
        int prev_max = 0;
        int cur_max = 0; 
        int max = 0;
        for (int num :nums){
            max = getMax(prev_max+num, cur_max);
            prev_max = cur_max;
            cur_max = max;
        }
        return max;
    }
    public int getMax (int a, int b){
        return (a>=b?a:b);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
