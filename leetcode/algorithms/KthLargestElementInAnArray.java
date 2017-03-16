package algorithms;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	// Solution 1: sort
    // public int findKthLargest(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     return nums[nums.length-k];
    // }
    
    // Solution 2: heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int num : nums) {
            heap.add(-num);
        }
        for (int i=0;i<k-1;i++) {
            heap.poll();
        }
        return -heap.poll();
    }
}
