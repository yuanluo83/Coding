package algorithms;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
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
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> visitedNodes = new HashSet<ListNode>();
        while (headA!=null || headB!=null ){
            if (headA !=null) {
                if (visitedNodes.contains(headA)){
                    return headA;
                }
                visitedNodes.add(headA);
                headA = headA.next;
            }
            if (headB !=null) {
                if (visitedNodes.contains(headB)){
                    return headB;
                }
                visitedNodes.add(headB);
                headB = headB.next;
            }
        }
        return null;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
