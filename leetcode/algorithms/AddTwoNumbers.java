package algorithms;

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
        ListNode p1=l1, p2=l2, c=p1;
        int digits_sum=0, carrier=0;
        while(p1!=null&&p2!=null){
            digits_sum=p1.val+p2.val+carrier;
            carrier=digits_sum/10;
            p1.val=digits_sum-carrier*10;
            c=p1;
            p1=p1.next;
            p2=p2.next;
        }
        while(p2!=null){
            c.next=p2;
            digits_sum=p2.val+carrier;
            carrier=digits_sum/10;
            p2.val=digits_sum-carrier*10;
            c=p2;
            p2=p2.next;
        }
        while(p1!=null){
            c.next=p1;
            digits_sum=p1.val+carrier;
            carrier=digits_sum/10;
            p1.val=digits_sum-carrier*10;
            c=p1;
            p1=p1.next;
        }
        if(carrier!=0){
            ListNode newNode=new ListNode(carrier);
            c.next=newNode;
        }
        return l1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
