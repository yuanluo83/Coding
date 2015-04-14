package com.leetcode.oj;

public class FindMinimuminRotatedSortedArrayII {

	public int findMin(int[] num) {
        return findMinRecursiveWithDuplicates(num, 0, num.length-1);
	}
	
	public int findMinRecursiveWithDuplicates(int[] num, int start, int end) {
        if(start==end){
            return num[start];
        }
        if(end-start==1){
            return num[start]<num[end]?num[start]:num[end];
        }
        if(num[start]<num[end]){
            return num[start];
        }
        int min=0;
        int middle=start+(end-start)/2;
        if(end-start>1){
            if(num[middle]>num[start]){
                start=middle;
                min=findMinRecursiveWithDuplicates(num, start, end);   
            }else if(num[middle]<num[start]) {
                end=middle;
                min=findMinRecursiveWithDuplicates(num, start, end);
            }else{
            	int leftMin=findMinRecursiveWithDuplicates(num, middle, end);
            	int rightMin=findMinRecursiveWithDuplicates(num, start, middle); 
            	min=(leftMin<=rightMin?leftMin:rightMin);
            }
        }
        return min;        
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArrayII mrsa = new FindMinimuminRotatedSortedArrayII();
		
		int[] num = {5,1,5,5,5,5,5};
		System.out.println(mrsa.findMin(num));
	}

}
