package com.leetcode.oj;

public class ReverseNodesinKGroup {

	
	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	} 
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1||head==null||head.next==null){
            return head;
        }
        
        int count=1;
        ListNode groupHead=head;
        ListNode groupTail=head;
        ListNode processedTail=null;
        ListNode pointer=head;
        ListNode nextNode = null;
        while (pointer!=null){
            nextNode=pointer.next;
            if(count % k == 0){
                reversePointers(groupHead, groupTail);
                
                if(processedTail == null){
                    head = groupTail;
                } else {
                    processedTail.next=groupTail;
                }
                processedTail = groupHead;
                groupHead.next=nextNode;
                groupHead=groupTail=nextNode;
                pointer=nextNode;
                count++;               
            }else{
                pointer=nextNode;
                groupTail=pointer;
                count++;
            }
        }
        return head;
    }
    
    public void reversePointers(ListNode head, ListNode tail){
        if (head == tail){
            return;
        }
        ListNode headNode = head;
        ListNode nextNode = head.next;
        ListNode secondNextNode = null;
        while(headNode!=tail){
        	System.out.println("reversing : " + headNode.val);
            secondNextNode = nextNode.next;
            nextNode.next = headNode;
            headNode = nextNode;
            nextNode =  secondNextNode;
        }
        head.next = null;
        return;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] values= {1,2,3};
    	int k = 2;
    	ReverseNodesinKGroup rnkg = new ReverseNodesinKGroup();
    	ListNode list = null;
    	ListNode pointer = null;
    	
    	for(int i = 0; i < values.length; i++){
    		ListNode node = rnkg.new ListNode(values[i]);
    		if(list == null){
    			list = node;
    		}else {
    			pointer.next = node;
    		}
			pointer = node;
    	}
    	
    	ListNode origlist = list;
    	while (origlist!=null){
    		System.out.print(origlist.val + " -> ");
    		origlist=origlist.next;
    	}
		System.out.println("null");
		
    	ListNode revlist = rnkg.reverseKGroup(list, k);
    	
    	while (revlist!=null){
    		System.out.print(revlist.val + " -> ");
    		revlist=revlist.next;
    	}
		System.out.println("null");
    	
	}

}
