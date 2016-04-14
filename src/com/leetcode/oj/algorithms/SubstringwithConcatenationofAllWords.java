package com.leetcode.oj.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	// Working code from https://leetcode.com/discuss/20885/accepted-short-java-solution
    public List<Integer> findSubstring(String S, String[] words) {
        List<Integer> result = new ArrayList<>();
        int size = words[0].length();
        if (words.length == 0 || words[0].isEmpty() || words[0].length() > S.length()) 
            return result;
        Map<String, Integer> hist = new HashMap<String, Integer>();
        for (String w : words) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int i = 0; i+size*words.length <= S.length(); i++) {
            if (hist.containsKey(S.substring(i, i+size))) {
                Map<String, Integer> currHist = new HashMap<String, Integer>();
                for (int j = 0; j < words.length; j++) {
                    String word = S.substring(i+j*size, i+(j+1)*size);
                    currHist.put(word, !currHist.containsKey(word) ? 
                        1 : currHist.get(word)+1);
                }
                if (currHist.equals(hist)) result.add(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
