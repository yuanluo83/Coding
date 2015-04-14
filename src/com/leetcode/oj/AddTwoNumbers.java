package com.leetcode.oj;

public class AddTwoNumbers {

	
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
	 	ListNode(int x) {
	 		val = x;
	 		next = null;
	 	}
	 }
	 
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
        }
		if(l2==null){
            return l1;
        }
        ListNode p1=l1, p2=l2, pp1=l1, pp2=l2;
        int carrier=0, temp=0;
        while(p1!=null&&p2!=null){
            temp=p1.val+p2.val+carrier;
            p1.val=temp % 10;
            carrier=temp/10;
            pp1=p1;
            p1=p1.next;
            pp2=p2;
            p2=p2.next;
        }
        if(p2!=null){
            pp1.next=p2;
            p1=p2;
        }
        while(p1!=null){
            temp=p1.val+carrier;
            p1.val=temp % 10;
            carrier=temp/10;
            pp1=p1;
            p1=p1.next;
        }
        if(carrier>0){
            ListNode extra=new ListNode(carrier);
            pp1.next=extra;
        }
        return l1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
