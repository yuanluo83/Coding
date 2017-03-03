/*
 * 76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 */
package algorithms;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashT = new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++){
            hashT.put(t.charAt(i), hashT.getOrDefault(t.charAt(i), 0)-1);
        }
        int start=0;
        int end=0;
        int minLength = -1;
        int minStart=-1;
        int minEnd=-1;
        int uniqCharNum = hashT.size();
        while (end<s.length()){
            char ch = s.charAt(end);
            if (hashT.containsKey(ch)) {
                int value = hashT.get(ch)+1;
                hashT.put(ch, value);
                if (value==0){
                    uniqCharNum--;
                }
                while (uniqCharNum==0) {
                    if (minLength<0 || minLength>end-start+1){
                        minStart=start;
                        minEnd=end;
                        minLength=end-start+1;
                    }
                    ch = s.charAt(start);
                    if (hashT.containsKey(ch)) {
                        value = hashT.get(ch)-1;
                        hashT.put(ch, value);
                        if (value<0){
                            uniqCharNum++;
                        }
                    }
                    start++;
                }
            }
            end++;
        }
        
        if (minLength<0){
            return "";
        }else {
            return s.substring(minStart,minEnd+1);
        }
        
    }
}
