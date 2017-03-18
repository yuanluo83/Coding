/*
 * 189. Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 */
package algorithms;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (k==0) {
            return;
        }
        int[] kNum = new int[k];
        for (int i = 0;i<k;i++){
            kNum[k-i-1] = nums[nums.length-i-1];
        }
        for (int i = nums.length-k-1; i>=0; i--){
            nums[k+i]= nums[i];
        }
        for (int i=0;i<k;i++){
            nums[i]=kNum[i];
        }
    }
}
