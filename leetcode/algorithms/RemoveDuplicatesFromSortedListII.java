package algorithms;


public class RemoveDuplicatesFromSortedListII {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummyHead = new ListNode(0);
    	dummyHead.next = head;
    	if (head == null || head.next == null)
        	return head;
        ListNode tail = dummyHead;
        ListNode p = head;
        boolean dup = false;
        
        while (p != null && p.next != null){
            if (p.val == p.next.val) {
            	p.next= p.next.next;
            	dup = true;
            } else {
            	if (dup){
            		p = p.next;
            		tail.next = p;
            		dup = false;
            	} else{
            		tail = p;
            		p = p.next;
            	}
            }
        }
        if (dup && p.next==null){
        	tail.next = p.next;
        }
        return dummyHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values= {1,1,2,3,3};
    	ListNode list = null;
    	ListNode pointer = null;
    	RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
    	
    	for(int i = 0; i < values.length; i++){
    		ListNode node = obj.new ListNode(values[i]);
    		if(list == null){
    			list = node;
    		}else {
    			pointer.next = node;
    		}
			pointer = node;
    	}
    	ListNode result = obj.deleteDuplicates(list);
    	
    	while (result!=null){
    		System.out.print(result.val + " -> ");
    		result=result.next;
    	}
		System.out.println("null");
	}

}
