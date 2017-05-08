/*
 * 98. Validate Binary Search Tree
 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

 */

package algorithms;

public class ValidateBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	    
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        } else {
            return getMinMax(root)[2]==1;
        }
    }
    
    public int[] getMinMax(TreeNode root) {
        int[] minMax = new int[3];
        minMax[0] = 0;
        minMax[1] = 0;
            
        if (root.left==null && root.right==null) {
            minMax[0] = root.val;
            minMax[1] = root.val;
            minMax[2] = 1;
            return minMax;
        } 
        int[] leftValues = null;
        int[] rightValues = null;
        if (root.left==null){
            rightValues = getMinMax(root.right);
            if (rightValues[2]==0){
                minMax[2] = 0;
                return minMax;
            } else if (root.val<rightValues[0]){
                minMax[0] = root.val;
                minMax[1] = rightValues[1];
                minMax[2] = 1;
            } else {
                minMax[2] = 0;
            }
            return minMax;
        }
        
        if (root.right==null){
            leftValues = getMinMax(root.left);
            if (leftValues[2]==0){
                minMax[2] = 0;
                return minMax;
            } else if (root.val>leftValues[1]){
                minMax[0] = leftValues[0];
                minMax[1] = root.val;
                minMax[2] = 1;
            } else {
                minMax[2] = 0;
            }
            return minMax;
        }
        
        leftValues = getMinMax(root.left);
        rightValues = getMinMax(root.right);

        if (leftValues[2]==0 || rightValues[2]==0){
            minMax[2] = 0;
            return minMax;
        } else if (root.val>leftValues[1] && root.val<rightValues[0]) {
            minMax[0] = leftValues[0];
            minMax[1] = rightValues[1];
            minMax[2] = 1;
        } else {
            minMax[2] = 0;
        }
        return minMax;
    }
}
