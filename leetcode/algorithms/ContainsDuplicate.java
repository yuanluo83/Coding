package algorithms;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
        
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7};
    	boolean result = new ContainsDuplicate().containsDuplicate(nums);
    	System.out.println(result);
	}
}

