package algorithms;

import java.util.Hashtable;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
        
        for (int i = 0; i<nums.length; i++){
            if (hs.get(nums[i]) != null && i - hs.get(nums[i]) <= k){
                return true;
            }
            hs.put(nums[i],i);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,3,6,7};
    	int k = 2;
    	boolean result = new ContainsDuplicateII().containsNearbyDuplicate(nums, k);
    	System.out.println(result);
	}
}

