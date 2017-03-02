/*
295. Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/

package algorithms;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
	
	public class MedianFinder {

	    PriorityQueue<Integer> leftPriorityQueue;
	    PriorityQueue<Integer> rightPriorityQueue;
	    
	    /** initialize your data structure here. */
	    public MedianFinder() {
	        leftPriorityQueue = new PriorityQueue<Integer>();
	        rightPriorityQueue = new PriorityQueue<Integer>();
	    }
	    
	    public void addNum(int num) {
	        if (leftPriorityQueue.size()==0 && rightPriorityQueue.size()==0){
	            leftPriorityQueue.add(-num);
	        }else if (leftPriorityQueue.size()<=rightPriorityQueue.size()){
	            if (rightPriorityQueue.peek()<num){
	                leftPriorityQueue.add(-rightPriorityQueue.poll());
	                rightPriorityQueue.add(num);
	            }else {
	                leftPriorityQueue.add(-num);
	            }
	        }else {
	            if (num<-leftPriorityQueue.peek()){
	                rightPriorityQueue.add(-leftPriorityQueue.poll());
	                leftPriorityQueue.add(-num);
	                System.out.println(leftPriorityQueue.size()+"="+rightPriorityQueue.size());
	            }else {
	                rightPriorityQueue.add(num);
	            }
	        }
	    }
	    
	    public double findMedian() {
	        if (leftPriorityQueue.size()==rightPriorityQueue.size()){
	            return ((double)-leftPriorityQueue.peek()+(double)rightPriorityQueue.peek())/2;
	        } else if (leftPriorityQueue.size()<rightPriorityQueue.size()) {
	            return (double)rightPriorityQueue.peek();
	        } else {
	            return (double)-leftPriorityQueue.peek();
	        }
	    }
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
}
