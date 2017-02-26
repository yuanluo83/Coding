package algorithms;

public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode temp = null;
        if (head != null) {
            head = head.next;
            newHead.next = null;
        }
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
        
    }
}

