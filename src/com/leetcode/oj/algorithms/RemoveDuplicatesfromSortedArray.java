package com.leetcode.oj.algorithms;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
        boolean dup=false;
        //int current=0;
        if (nums.length==0){return 0;}
        int current_val = nums[0];
        int candicate_pos = 0;
        int max=nums.length;
        for (int i=1;i<nums.length;i++){
            if(nums[i]!=current_val){
                if(dup){
                    nums[candicate_pos]=nums[i];
                    candicate_pos++;
                }
                current_val=nums[i];
            }else if(!dup){
                dup=true;
                candicate_pos=i;
                current_val=nums[candicate_pos];
                max--;
            }else {
            	//nums[candicate_pos]=nums[i];
                //candicate_pos++;
                max--;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,2,2,3,3,3,4,4,4};
		int max = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
		System.out.print(max);
		for (int num:nums){
			System.out.print(","+num);
		}
	}

}
