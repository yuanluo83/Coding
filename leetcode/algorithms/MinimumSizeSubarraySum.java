/*
 * 209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

 */

package algorithms;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start<nums.length && end<nums.length){
            while (sum<s && end<nums.length){
                sum = sum + nums[end];
                end++;
            }
            while (sum>=s && start<end){
                minLen = Math.min(minLen, end-start);
                sum = sum - nums[start];
                start++;
                
            }
            
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}
