/*
 * 23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 */

package algorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MergekSortedLists {
	

	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer, ArrayList<Integer>> heap = new TreeMap<Integer, ArrayList<Integer>>();
        // Put the first element of each list into the heap
        for (int i=0; i<lists.length;i++){
            ListNode node = lists[i];
            if (node==null) {
                continue;
            } else if (!heap.containsKey(node.val)){
                ArrayList<Integer> listIndices = new ArrayList<Integer>();
                heap.put(node.val, listIndices);
            }
            heap.get(node.val).add(i);
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while (!heap.isEmpty()){
            Map.Entry<Integer, ArrayList<Integer>> firstEntry = heap.firstEntry();
            ArrayList<Integer> listIndices = firstEntry.getValue();
            int listIndex = listIndices.get(0);
            listIndices.remove(0);
            if (listIndices.isEmpty()){
                heap.pollFirstEntry();
            }
            
            ListNode node = lists[listIndex];
            tail.next = node;
            tail = tail.next;
            lists[listIndex] = node.next;
            tail.next = null;
            
            node = lists[listIndex];
            if (node==null) {
                continue;
            } else if (!heap.containsKey(node.val)){
                heap.put(node.val, new ArrayList<Integer>());
            }
            heap.get(node.val).add(listIndex);
        }
        return head.next;
        
    }
	
	/*
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0){
            return null;
        } else if(lists.size()==1){
            return lists.get(0);
        }else if(lists.size()==2){
            ListNode head = null;
            ListNode list1 =  lists.get(0);
            ListNode list2 = lists.get(1);
            ListNode list3 = head;
            while(list1!=null || list2!=null){
                if (list1!=null && list2!=null){
                    if(list1.val <= list2.val){
                        if(head==null){
                            list3 = list1;
                            head = list3;
                        }else{
                            list3.next = list1;
                            list3 = list3.next;
                        }
                        list1 = list1.next;
                    }else {
                        if(head==null){
                            list3 = list2;
                            head = list3;
                        }else{
                            list3.next = list2;
                            list3 = list3.next;
                        }
                        list2 = list2.next;
                    }
                } else if(list1!=null){
                    if(head==null){
                        list3 = list1;
                        head = list3;
                    }else{
                        list3.next = list1;
                    }
                    break;
                } else if(list2!=null){
                    if(head==null){
                        list3 = list2;
                        head = list3;
                    }else{
                        list3.next = list2;
                    }
                    break;
                }
            }
            return head;
        }else {
            ArrayList<ListNode> ln = new ArrayList<ListNode>();
            ln.add(mergeKLists(lists.subList(0,lists.size()/2)));
            ln.add(mergeKLists(lists.subList((lists.size()/2), lists.size())));
            return mergeKLists((List)ln);
        }
    }
    */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
