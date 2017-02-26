package algorithms;

import java.util.Hashtable;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

	if(k<=0||t<0||nums.length < 2) return false;
		
        Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();

        if (t==0) {
            for (int i = 0; i<nums.length; i++){
            	if (i>k) {
                	hs.remove(nums[i-k-1]);
                }
                if (hs.containsKey(nums[i])){
                    return true;
                }
                hs.put(nums[i],i);
            }
            // Alternative for loop , without remove(): 
			/*
            for (int i = 0; i<nums.length; i++){
				if (hs.get(nums[i]) != null && i - hs.get(nums[i]) <= k){
					return true;
				}
				hs.put(nums[i],i);
			}
			*/
            return false;
        } else{
            for (int i = 0; i<nums.length; i++){
            	if (i>k) {
                	// windowing, only preserve k#
                	hs.remove(nums[i-k-1]/t);
                }
                if (hs.get(nums[i]/t) != null ){
                	int delta = Math.abs(nums[i] - nums[hs.get(nums[i]/t)]);
                	// The delta value could be larger than t, if one number is in (-t,0) and the other is in (0,t)
                	if ( delta<=t) return true;
                }
                if (hs.get(nums[i]/t-1) != null ){
                	int delta = nums[i] - nums[hs.get(nums[i]/t-1)];
                	// If delta < 0, the distance between to numbers is larger than Integer.MAX_VALUE, which is larger than t.
                	if ( delta<=t && delta >0) return true;
                }
                if (hs.get(nums[i]/t+1) != null ){
                	int delta = nums[hs.get(nums[i]/t+1)] - nums[i];
                	// If delta < 0, the distance between to numbers is larger than Integer.MAX_VALUE, which is larger than t.
                	if ( delta<=t && delta >0) return true;
                }    
                hs.put(nums[i]/t,i);
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
    	//int[] nums = {1,4,8,11,14,17,15};
    	int[] nums = {-1,2147483647};
    	
    	int k = 1;
    	int t = 2147483647;
    	boolean result = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, k, t);
    	System.out.println(result);

	}
}

