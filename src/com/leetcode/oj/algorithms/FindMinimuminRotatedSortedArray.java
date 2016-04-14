package com.leetcode.oj.algorithms;

public class FindMinimuminRotatedSortedArray {

	public int findMin(int[] num) {
        return findMinRecursive(num, 0, num.length-1);
	}
    
    public int findMinIterative(int[] num) {

        if(num.length==0){
            return 0;
        }
        if(num.length==1){
            return num[0];
        }
        if(num.length==2){
            return num[0]<num[1]?num[0]:num[1];
        }
        if(num[0]<num[num.length-1]){
            return num[0];
        }
        
        int start=0;
        int end=num.length-1;
        int middle=start+(end-start)/2;
        while(end-start>1){
            if(num[middle]>num[start]){
                start=middle;
            }else {
                end=middle;
            }
            middle=start+(end-start)/2;
        }
        return num[start]<num[end]?num[start]:num[end];
       
    }
    
    public int findMinRecursive(int[] num, int start, int end) {
        if(start==end){
            return num[start];
        }
        if(end-start==1){
            return num[start]<num[end]?num[start]:num[end];
        }
        if(num[start]<num[end]){
            return num[start];
        }
        
        int middle=start+(end-start)/2;
        if(end-start>1){
            if(num[middle]>=num[start]){
                start=middle;
            }else {
                end=middle;
            }
        }
        return findMinRecursive(num, start, end);        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArray mrsa = new FindMinimuminRotatedSortedArray();
		
		//int[] num = {3,4,6,8,9,10,34,1,2};
		int[] num={1};
		System.out.println(mrsa.findMin(num));
	}

}
