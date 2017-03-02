package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        int[] frequencyArray = new int[255];
        TreeMap<Integer,List<Character>> frequencyMap = new TreeMap<Integer,List<Character>>();
        for(int i=0;i<s.length();i++){
            frequencyArray[s.charAt(i)] = frequencyArray[s.charAt(i)] + 1 ;
        }
        for (int charInt=0;charInt<frequencyArray.length;charInt++){
            
            List<Character> list = frequencyMap.get(frequencyArray[charInt]);
            if (list==null){
                list = new ArrayList<Character>();
                list.add((char) charInt);
                frequencyMap.put(frequencyArray[charInt], list);
            } else {
                list.add((char) charInt);
            }
        }
        String result = "";
        while (frequencyMap.size()!=0){
            Map.Entry<Integer,List<Character>> entry = frequencyMap.pollLastEntry();
            List<Character> list = entry.getValue();
            int frequency = entry.getKey();
        	for (Character ch : list) {
        		result = result + new String(new char[frequency]).replace('\0', ch);
    		}

        }
        return result;
    }
}
