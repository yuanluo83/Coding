/*
 * 303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

 */
package algorithms;

public class RangeSumQueryImmutable {
	public class NumArray {

	    int[] prefixValue;
	    public NumArray(int[] nums) {
	        if (nums.length>0){
	            prefixValue = new int[nums.length];
	            prefixValue[0] = nums[0];
	            for (int i=1;i<nums.length;i++){
	                prefixValue[i] = prefixValue[i-1] + nums[i]; 
	            }
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	        return i==0 ? prefixValue[j]: prefixValue[j]-prefixValue[i-1];
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
}
