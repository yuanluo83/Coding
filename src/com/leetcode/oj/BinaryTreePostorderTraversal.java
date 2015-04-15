package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.BinaryTreeRightSideView.StackObject;
import com.leetcode.oj.BinaryTreeRightSideView.TreeNode;

public class BinaryTreePostorderTraversal {
	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	ArrayList<Integer> list= new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postoderRecursive(root);
        return list;
    }
    
    public void postoderRecursive(TreeNode root){
        if(root==null){
            return;
        }
        postoderRecursive(root.left);
        postoderRecursive(root.right);
        list.add(root.val);
    }
    
    public void postorderIterative(TreeNode root){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode lastVisitedNode=null;
        while (root!=null||!stack.isEmpty()){
        	if(root!=null){
        		stack.push(root);
        		root=root.left;
        	}else if(!stack.isEmpty()){
	        	TreeNode peeknode = stack.peek();
	        	if(peeknode.right!=null&&lastVisitedNode!=peeknode.right){
	        		root=peeknode.right;
	        	}else{
	        		lastVisitedNode=stack.pop();
	        		list.add(lastVisitedNode.val);
	        	}
	        }
        }
    }
     
  
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
