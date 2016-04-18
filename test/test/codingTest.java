package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class codingTest {
	
	static int maxStep(int N, int K) {
        int max = (N+1)*N/2;
        if (max<K){
            return max;
        } else {
            int sqrt = (int) Math.sqrt(2*K-1);
            if (sqrt*(sqrt+1)/2==K){
                return max-1;
            }else {
                return max;
            }
        }

    }
	
	static int[] StringSimilarity(String[] inputs) {
        int[] count=new int[inputs.length];
        for (int x=0; x<inputs.length; x++){
            count[x]= count[x]+inputs[x].length();
            char[] inputArray = inputs[x].toCharArray(); // toCharArray() can significantly improve the performance.
            for (int i=1; i<inputArray.length; i++){
                for (int j=0; j<inputArray.length-i; j++){
                    if(inputArray[i+j]==inputArray[j]){
                        count[x]++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }

	
	static int numberOfPaths(int [][]a,int M,int N) {
	    if(M*N==0||a[M-1][N-1]*a[0][0]==0){
	        return 0;
	    }
	    return numberOfPathsHelp(a, M, N, 0, 0);
	}

	static int numberOfPathsHelp(int [][]a, int M,int N, int row, int column) {
	    if(row==M-1&&column==N-1){
	        return 1;
	    }
	    int number=0;
	    if (row+1<M&&a[row+1][column]==1){
	        number = number + numberOfPathsHelp(a, M, N, row+1, column);
	    }
	    if (column+1<N&&a[row][column+1]==1){
	        number = number + numberOfPathsHelp(a, M, N, row, column+1);
	    }
	    return number;
	}
	/*
	static int numberOfPaths(int [][]a,int M,int N) {
	    if(M*N==0||a[M-1][N-1]*a[0][0]==0){
	        return 0;
	    }
	    Integer[][] b = new Integer[M][N];
	    return numberOfPathsHelp(a, b, M, N, 0, 0);
	}

	static int numberOfPathsHelp(int [][]a, Integer[][] b, int M,int N, int row, int column) {
	    if(row==M-1&&column==N-1){
	        return a[M-1][N-1];
	    }
	    int number=0;
	    if (row+1<M&&a[row+1][column]==1){
	        if(b[row+1][column]==null){
	            b[row+1][column]=new Integer(numberOfPathsHelp(a, b, M, N, row+1, column));
	        }
	        number = number + b[row+1][column];
	    }
	    if (column+1<N&&a[row][column+1]==1){
	        if(b[row][column+1]==null){
	            b[row][column+1]=new Integer(numberOfPathsHelp(a, b, M, N, row, column+1));
	        }
	        number = number + b[row][column+1];
	    }
	    return number;
	}
	*/
	
	// 6/10 
	/*
	static int numberOfPaths(int [][]a,int M,int N) {
	    if(M*N==0||a[M-1][N-1]*a[0][0]==0){
	        return 0;
	    }
	    Integer[][] b = new Integer[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                b[i][j] = null;
            }
        }
	    return numberOfPathsHelp(a, b, M, N, 0, 0);
	}

	static int numberOfPathsHelp(int [][]a, Integer[][] b, int M,int N, int row, int column) {
        if(b[row][column]!=null){
            return b[row][column].intValue();
        }
        int number=0;
        if(a[row][column]==0){
            number=0;
        } else if(row==M-1&&column==N-1){
            number=a[M-1][N-1];
	    } else {
            if (row+1<M){
                number = numberOfPathsHelp(a, b, M, N, row+1, column);
            }
            if (column+1<N){
                number = number + numberOfPathsHelp(a, b, M, N, row, column+1);
            }
        } 
        
        b[row][column]=new Integer(number);

	    return number;
	}
	*/
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _N;
        _N = Integer.parseInt(in.nextLine());
        String str="";

        int _K;
        _K = Integer.parseInt(in.nextLine());
        
        res = maxStep(_N, _K);
        System.out.println(res);
        //bw.write(String.valueOf(res));
        //bw.newLine();
        
        //bw.close();
    }

}
