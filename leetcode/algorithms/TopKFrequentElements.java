package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TopKFrequentElements {
	//Use heap (TreeMap) to track the top K elements.
	public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, List<Integer>> heap = new TreeMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : map.keySet()){
            if (heap.containsKey(map.get(num))){
            	heap.get(map.get(num)).add(num);
            }else{
                List<Integer> values = new ArrayList<Integer>();
                values.add(num);
                heap.put(map.get(num), values);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        while( k>0 && heap.size()>0){
            List<Integer> values = heap.pollLastEntry().getValue();
            for (int i=0;i<values.size()&&k>0;i++) {
                result.add(values.get(i));
                k--;
            }
        }
        return result;
    }
	
	public List<Integer> topKFrequentII(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int newValue;
        int max=0;
        for (int num : nums) {
            newValue = map.getOrDefault(num, 0) + 1;
            map.put(num, newValue);
            max = newValue > max ? newValue : max;
        }
        List<Integer>[] list = new List[max+1];
        for (Integer num : map.keySet()){
        	map.get(num);
            if (list[map.get(num)]!=null){
            	list[map.get(num)].add(num);
            }else{
                List<Integer> values = new ArrayList<Integer>();
                values.add(num);
                list[map.get(num)] = values;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for ( int freq=list.length-1; freq>0 && k>0; freq--){
            List<Integer> values = list[freq];
            if (values!=null){
                for (int i=0;i<values.size()&&k>0;i++) {
                    result.add(values.get(i));
                    k--;
                }
            }
        }
        return result;
    }
}
