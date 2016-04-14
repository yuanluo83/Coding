package com.leetcode.oj.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
    
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j))){
                if(j==0){
                    result.add(s);
                    return result;
                }
                break;
            }
            else if(j == 0){
                return result;
            }
        }
    
        for(int i = 0; i < s.length()-1; i++){
            if(dict.contains(s.substring(0,i+1))){
                List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
                if(strs.size() != 0){
                    for(Iterator<String> it = strs.iterator();it.hasNext();){
                        result.add(s.substring(0,i+1)+" "+it.next());
                    }
                }
            }
        }
        if(dict.contains(s)) {
            result.add(s);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
