/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
    
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/
package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public class Codec {
	    
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        StringBuilder result = new StringBuilder();
	        while (!queue.isEmpty()){
	            TreeNode current = queue.poll();
	            if (current != null){
	                result.append(" " + current.val);
	                queue.add(current.left);
	                queue.add(current.right);
	            } else {
	              result.append(" n");
	            }
	        }
	        //System.out.println(result);
	        return result.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        queue = new LinkedList<TreeNode>();
	        String[] values = data.trim().split(" ");
	        if (values.length == 0|| values[0].equals("n")){
	            return null;
	        }
	        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
	        queue.add(root);
	        int i = 1;
	        int end = values.length - 1;
	        while(!queue.isEmpty() && i <= end){
	            TreeNode current = queue.poll();
	            if (values[i].equals("n")){
	                current.left = null;
	            } else {
	                current.left = new TreeNode(Integer.valueOf(values[i]));
	                queue.add(current.left);
	            }
	            i++;
	            if (i<values.length){
	                if (values[i].equals("n")){
	                    current.right = null;
	                } else {
	                    current.right = new TreeNode(Integer.valueOf(values[i]));
	                    queue.add(current.right);
	                }
	                i++;
	            }
	        }
	        return root;
	    }
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
