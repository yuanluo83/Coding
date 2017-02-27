package algorithms;


public class RemoveDuplicatesFromSortedList {
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
        ListNode p = head;
        while (p != null && p.next != null){
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values= {1,2,2,3};
    	ListNode list = null;
    	ListNode pointer = null;
    	RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
    	
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
