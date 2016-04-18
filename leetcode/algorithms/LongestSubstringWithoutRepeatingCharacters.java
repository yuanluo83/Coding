package algorithms;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
        int currentLongest = 0;
        int currentLength = 0;
        int start=0;
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        for(int index=0;index<s.length();index++){
            char c = s.charAt(index);
            if(hm.containsKey(c)){
                if(start<hm.get(c)){
                    start = hm.get(c);
                }
                currentLength=index-start;
                hm.put(c,index);
            }else{
                hm.put(c,index);
                currentLength++;
            }
            if(currentLength>currentLongest){
                currentLongest=currentLength;
            }
        }
        
        return currentLongest;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
