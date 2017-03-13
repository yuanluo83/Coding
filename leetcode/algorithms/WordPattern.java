/*
 * 290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

 */

package algorithms;

import java.util.HashMap;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> fwdMap = new HashMap<Character, String>();
        HashMap<String, Character> revMap = new HashMap<String, Character>();
        String[] strList = str.split(" ");
        if(pattern.length() != strList.length) {
            return false;
        }
        int i = 0;
        while (i<strList.length){
            if (fwdMap.containsKey(pattern.charAt(i))){
                if (!fwdMap.get(pattern.charAt(i)).equals(strList[i])){
                    return false;
                }
            } else if (revMap.containsKey(strList[i])){
                if (!revMap.get(strList[i]).equals(pattern.charAt(i))){
                    return false;
                }
            } else {
                fwdMap.put(pattern.charAt(i), strList[i]);
                revMap.put(strList[i], pattern.charAt(i));
            }
            i++;
        }
        return true;
    }

}
