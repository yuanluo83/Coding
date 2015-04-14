package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	
	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        //recTreeTravel(root,0,list);
        iterTreeTravel(root,list);
        return list;
    }
    
    //Recursive tree traveral (root->right->left)
    
    public void recTreeTravel(TreeNode root, int level, List<Integer> list){
        if(root!=null){
            level++;
            if(level>list.size()){
                list.add(root.val);
            }
            recTreeTravel(root.right,level,list);
            recTreeTravel(root.left,level,list);
        }
    }
    
    //Iterative tree traveral (root->right->left)
    public void iterTreeTravel(TreeNode root, List<Integer> list){
        Stack stack=new Stack();
        int level=0;
        StackObject obj=null;
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                level++;
                if(level>list.size()){
                    list.add(root.val);
                }
                if(root.left!=null){
                    stack.push(new StackObject(root.left,level));
                }
                root=root.right;
            }else{
                obj=stack.pop();
                level=obj.level;
                root=obj.node;
            }
            
        }
    }

    public class Stack{
        
        ArrayList<StackObject> list = new ArrayList<StackObject>();
        
        public void push(StackObject obj){
            list.add(obj);
        }
        
        public StackObject pop(){
            StackObject obj= list.get(list.size() - 1);
            obj=new StackObject(obj.node, obj.level);
            list.remove(list.size() - 1);
            return obj;
        }
        
        public boolean isEmpty(){
            return list.isEmpty();
        }
    }
    
    public class StackObject{
        
        public TreeNode node;
        public int level;
        public StackObject(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
