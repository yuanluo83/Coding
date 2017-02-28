/*
 * 398. Random Pick Index
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * Note: The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * 
 * Sample:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */

package algorithms;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// Construct: O(n), pick: O(1)
public class RandomPickIndex {

	Hashtable<Integer, List<Integer>> hTable;
	    
    public RandomPickIndex(int[] nums) {
        hTable = new Hashtable<Integer, List<Integer>>();
        for (int i=0;i<nums.length;i++){
            if (hTable.containsKey(nums[i])){
                hTable.get(nums[i]).add(i);
            }else {
                List<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                hTable.put(nums[i], indices);
            }
        }
    }
    
    public int pick(int target) {
        if (!hTable.containsKey(target)){
            return -1;
        }else {
            List<Integer> indices = hTable.get(target);
            return indices.get(new Random().nextInt(indices.size()));
        }
    }
}

//Alternatively, to save a little bit space, change Hashtable<Integer, List<Integer>> to Hashtable<Integer, String>. It will increase pick time though.
/*

public class RandomPickIndex {
    
    Hashtable<Integer, String> hTable;
    
    public RandomPickIndex(int[] nums) {
        hTable = new Hashtable<Integer, String>();
        for (int i=0;i<nums.length;i++){
            if (hTable.containsKey(nums[i])){
                hTable.put(nums[i], hTable.get(nums[i])+"-"+String.valueOf(i));
            }else {
                hTable.put(nums[i], String.valueOf(i));
            }
        }
    }
    
    public int pick(int target) {
        if (!hTable.containsKey(target)){
            return -1;
        }else {
            String[] indices = hTable.get(target).split("-");
            //for (int i=0;i<indices.length;i++){System.out.println(indices[i]);}
            return Integer.parseInt(indices[new Random().nextInt(indices.length)]);
        }
    }
}

*/


