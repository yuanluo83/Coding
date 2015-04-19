package com.leetcode.oj;


public class CopyListwithRandomPointer {

	
	//Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
    
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        
        RandomListNode headPointer1 = null, headPointer2 = null, head2 = null;
        headPointer1 = head;
        
        // First round: copy each node, link the copy next to the original.
        while (headPointer1!=null){
            if(head2==null){
                headPointer2 = new RandomListNode(head.label);
                head2 = headPointer2;
            } else {
                headPointer2 = new RandomListNode(headPointer1.label);
            }
            headPointer2.next = headPointer1.next;
            headPointer1.next = headPointer2;
            headPointer1 = headPointer2.next;
        }
        
        headPointer1 = head;
        headPointer2 = head2;
        
        // Second round: assign random pointers.
        while(headPointer2!=null){
            if(headPointer1.random==null){
                headPointer2.random = null;
            }else {
                headPointer2.random = headPointer1.random.next;
            }
            if(headPointer2.next!=null){
                headPointer1 = headPointer2.next;
                headPointer2 = headPointer1.next;
            } else {
                headPointer1 = headPointer2 = null;
            }
        }
        
        headPointer1 = head;
        headPointer2 = head2;
        
        // Third round: separate original and copy from one list to two.
        while(headPointer1!=null && headPointer2!=null){
            headPointer1.next = headPointer2.next;
            headPointer1 = headPointer1.next;
            
            if(headPointer1 == null){
                headPointer2 = null;
            }else {
                headPointer2.next = headPointer1.next;
                headPointer2 = headPointer2.next;
            }
        }
        
        return head2;
    }

}
