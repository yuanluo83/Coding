/*
 * 97. Interleaving String

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

 */

package algorithms;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()){
            return false;
        } 
        int[][] state = new int[s1.length() + 1][s2.length() + 1];
        state[0][0] = 1;
        for(int i=1; i<=s1.length();i++){
            state[i][0] = ( state[i-1][0]==1 && s1.charAt(i-1) == s3.charAt(i-1) ? 1 : 0 );
        }
        for(int j=1; j<=s2.length();j++){
            state[0][j] = ( state[0][j-1]==1 && s2.charAt(j-1) == s3.charAt(j-1) ? 1 : 0 );
        }
        for(int i=1; i<=s1.length();i++){
            for(int j=1; j<=s2.length();j++){
                if (state[i-1][j]==1 && s1.charAt(i-1)==s3.charAt(i+j-1)){
                    state[i][j]=1;
                } else if (state[i][j-1]==1 && s2.charAt(j-1)==s3.charAt(i+j-1)){
                    state[i][j]=1;
                } else{
                    state[i][j]=0;
                }
            }
        }
        return state[s1.length()][s2.length()]==1? true: false;
    }
}
