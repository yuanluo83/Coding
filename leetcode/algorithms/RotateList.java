/*
 * 61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 */

package algorithms;

public class RotateList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode p1 = head;
        while (p1!=null) {
            p1=p1.next;
            n++;
        }
        if (n<=1) return head;
        k = k % n;
        p1 = head;
        ListNode p2 = head;
        while (k>0) {
            p2 = p2.next;
            k--;
        }
        while (p2.next!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        p2.next = head;
        head = p1.next;
        p1.next = null;
        return head;
    }
}
