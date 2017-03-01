/*
128. Longest Consecutive Sequence Add to List

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */

package algorithms;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hSet.add(nums[i]);
        }
        int max=0;
        int current;
        int count=0;
        for(int i=0;i<nums.length;i++){
            current = nums[i];
            //only do the counting when the nums[i] is the starting sequence.
            if(!hSet.contains(current-1)){
                while (hSet.contains(current)){
                    current++;
                    count++;
                }
                max = max >= count? max : count;
                count = 0;
            }
        }
        return max;
    }
}