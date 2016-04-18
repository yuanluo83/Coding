package algorithms;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfPathsInAMatrix {

	static int numberOfPaths(int [][]a,int M,int N) {
	    if(M*N==0||a[M-1][N-1]*a[0][0]==0){
	        return 0;
	    }
        Map<String, Integer> hm = new HashMap<String, Integer>() ;
	    return numberOfPathsHelp(a, hm, M, N, 0, 0);
	}

	static int numberOfPathsHelp(int [][]a, Map<String, Integer> hm, int M,int N, int row, int column) {
        String key = String.valueOf(row)+":"+String.valueOf(column);
        if(hm.containsKey(key)){
        	System.out.println("got "+key +", value=" +hm.get(key)); 
            return hm.get(key);
        }
        int number=0;
        if(a[row][column]==0){
            number=0;
        } else if(row==M-1&&column==N-1){
            number=a[M-1][N-1];
	    } else {
            if (row+1<M){
                number = numberOfPathsHelp(a, hm, M, N, row+1, column);
            }
            if (column+1<N){
                number = number + numberOfPathsHelp(a, hm, M, N, row, column+1);
            }
        } 
        hm.put(key,number);

	    return number;
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		int _a_cnt = 0,_b_cnt = 0;
		int [][] _a = new int[1001][1001];
		try {
			_a_cnt = sc.nextInt();
			_b_cnt = sc.nextInt();
		}catch (Exception e) {
			 System.out.println("Here: " + e.getMessage()); 
		} 

		for(int i=0; i < _a_cnt; i++) {
			for( int j = 0;j < _b_cnt;j++ ){
				int _a_tmp = 0;
				try {
					_a_tmp = sc.nextInt();
				}catch (Exception e) { }
				_a[i][j] = _a_tmp;
			}			
		}
		System.out.println(numberOfPaths (_a ,_a_cnt,_b_cnt));

	}
}
