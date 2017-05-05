/*
 * 108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 */
package algorithms;



public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int leftIndex, int rightIndex){
        if(leftIndex>rightIndex){
            return null;
        }
        int mid = (leftIndex+rightIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, leftIndex, mid-1);
        root.right = helper(nums, mid+1, rightIndex);
        return root;
    }
}
