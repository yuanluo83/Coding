/*
 * 125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

 */

package algorithms;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length()-1;
        while (begin<end){
            while((s.charAt(begin)<'0'||(s.charAt(begin)>'9'&&s.charAt(begin)<'A')||(s.charAt(begin)>'Z'&&s.charAt(begin)<'a')||s.charAt(begin)>'z')&&begin<end){
                begin++;
            }
            while((s.charAt(end)<'0'||(s.charAt(end)>'9'&&s.charAt(end)<'A')||(s.charAt(end)>'Z'&&s.charAt(end)<'a')||s.charAt(end)>'z')&&begin<end){
                end--;
            }
            if(begin>=end){
                return true;
            } else if (Character.toLowerCase(s.charAt(begin))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
