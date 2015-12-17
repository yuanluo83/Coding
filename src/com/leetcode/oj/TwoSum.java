package com.leetcode.oj;
import java.util.*;


public class TwoSum {
	// 5ms ! kick-ass code
	public int[] twoSum0(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] eresult = {0,0};
    
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                int[] result = {map.get(nums[i])+1,i+1};
                return result;
            }
            //put target-num[i] instead of num[i] prevents target-num[i] to be performed twice.
            map.put(target-nums[i], i);
            /* much slower operation as target-num[i] is computed twice. Adding an int value does not help.
            if(map.get(target-nums[i]) != null) {
                int[] result = {map.get(target-nums[i])+1,i+1};
                return result;
            }
            map.put(nums[i], i);            
             */
           
        }
        return eresult;

    }
	
	//258ms
    public int[] twoSum1(int[] numbers, int target) {
        int size=numbers.length;
        int[] index=new int[2];
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<size;i++){
            map.put(numbers[i],i+1);
        }
        for (int i=0; i<size;i++){
            Integer sec=(Integer)map.get(target-numbers[i]);
            if(sec!=null&&sec.intValue()>i+1){
                index[0]=i+1;
                index[1]=sec.intValue();
            }
        }
        return index;
    }
    //241ms
    public int[] twoSum2(int[] numbers, int target) {
        int size=numbers.length;
        int[] index=new int[2];
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<size;i++){
            map.put(numbers[i],i+1);
        }
        for (int i=0; i<size;i++){
            //Integer sec=(Integer)map.get(target-numbers[i]);
            if(map.get(target-numbers[i])!=null&&map.get(target-numbers[i])>i+1){
                index[0]=i+1;
                index[1]=map.get(target-numbers[i]);
            }
        }
        return index;
    }
    //238ms
    public int[] twoSum3(int[] numbers, int target) {
        //int size=numbers.length;
        int[] index=new int[2];
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        for (int i=0; i<numbers.length;i++){
            //Integer sec=(Integer)map.get(target-numbers[i]);
            if(map.get(target-numbers[i])!=null&&map.get(target-numbers[i])>i+1){
                index[0]=i+1;
                index[1]=map.get(target-numbers[i]);
            }
        }
        return index;
    }
    
  //237ms
    public int[] twoSum4(int[] numbers, int target) {
        //int size=numbers.length;
        //int[] index=new int[2];
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0;i<numbers.length;i++){
            map.put(numbers[i],i+1);
        }
        for (int i=0; i<numbers.length;i++){
            //Integer sec=(Integer)map.get(target-numbers[i]);
            if(map.get(target-numbers[i])!=null&&map.get(target-numbers[i])>i+1){
            	int[] index=new int[2];
                index[0]=i+1;
                index[1]=map.get(target-numbers[i]);
                return index;
            }
        }
        return null;
    }
}

