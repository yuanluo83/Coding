package com.leetcode.oj.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.algorithms.BinaryTreeRightSideView.StackObject;
import com.leetcode.oj.algorithms.BinaryTreeRightSideView.TreeNode;

public class BinaryTreePreorderTraversal {
	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	ArrayList<Integer> list= new ArrayList<Integer>();
	
    public List<Integer> preorderTraversal(TreeNode root) {
        //preoderRecursive(root);
        preoderIterative(root);
        return list;
    }
    
    public void preoderRecursive(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        preoderRecursive(root.left);
        preoderRecursive(root.right);
        
    }
    
    public void preoderIterative(TreeNode root){
    	if(root==null){
            return;
        }
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
        while (!stack.isEmpty()){
        	root=stack.pop();
    		list.add(root.val);
    		if(root.right!=null){
    			stack.push(root.right);
    		}
    		if(root.left!=null){
    			stack.push(root.left);
    		}
        }
    }
     
  
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
