package algorithms;

import java.util.List;

public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s==null||s.length()==0){
			return true;
		}
		
		if(wordDict==null){
			return true;
		}
        
		boolean[] check=new boolean[s.length()+1];
		check[0]=true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				if(check[j]&&wordDict.contains(s.substring(j,i+1))){
					check[i+1]= true;
					break;
				}
			}
		}
		
		return check[s.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
