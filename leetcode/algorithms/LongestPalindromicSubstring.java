package algorithms;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        int max=1;
        int count1=1,count2=0;
        int start=0, end=0;
        int maxStart=0, maxEnd=0;
        char[] str=s.toCharArray();
        for(int i=0;i<str.length;i++){
            count1=1;
            for(int j=1; j<=min(i,str.length-i);j++){
                if((i+j<str.length)&&(str[i-j]==(str[i+j]))){
                    count1=count1+2;
                    start=i-j;
                    end=i+j;
                }else{
                    break;
                }
            }
            if(count1>max){
                max=count1;
                maxStart=start;
                maxEnd=end;
            }
            count2=0;
            for(int j=0; j<min(i+1,str.length-i-1);j++){
                if((i+j+1<str.length)&&(str[i-j]==(str[i+j+1]))){
                    count2=count2+2;
                    start=i-j;
                    end=i+j+1;
                }else{
                    break;
                }
            }
            if(count2>max){
                max=count2;
                maxStart=start;
                maxEnd=end;
            }
            
        }
        return s.substring(maxStart, maxEnd+1);
    }
    
    public int min(int i, int j){
        if(i>j){
            return j;
        }
        return i;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
