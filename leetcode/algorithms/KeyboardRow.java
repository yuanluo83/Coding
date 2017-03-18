/*
 * 500. Keyboard Row

Given a List of words, return the words that can be typed using 
letters of alphabet on only one row's of American keyboard like 
the image below.
https://leetcode.com/static/images/problemset/keyboard.png

Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]


 */

package algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyboardRow {
	HashMap<Character, Integer> board;
    public KeyboardRow() {
        String[] lines = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        board = new HashMap<Character, Integer>();
        for (int i=0;i<lines.length;i++){
            for (int j=0;j<lines[i].length();j++){
                board.put(lines[i].charAt(j), i);
            }
        }
    }
    
    public String[] findWords(String[] words) {
        ArrayList<String> strings = new ArrayList<String>();
        int lineNumber = -1;
        boolean valid = true;
        for (String word : words){
            lineNumber = -1;
            valid = true;
            for (int j=0;j<word.length();j++){
                if (lineNumber != -1 && board.get(Character.toLowerCase(word.charAt(j))) != lineNumber){
                    valid = false;
                    break;
                } else {
                    lineNumber = board.get(Character.toLowerCase(word.charAt(j)));
                }
            }
            if (valid){
                strings.add(word);
            }
        }
        return strings.toArray(new String[0]);
    }
}
