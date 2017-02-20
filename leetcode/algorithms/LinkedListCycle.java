package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
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
	
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<ListNode>();
        ListNode p = head;
        while (p!=null){
            if (seenNodes.contains(p)){
                return true;
            } else {
                seenNodes.add(p);
                p = p.next;
            }
        }
        return false;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
