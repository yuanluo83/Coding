package algorithms;

public class ZigZagConversion {

	public String convert(String s, int nRows) {
        if(nRows==1){
            return s;
        }
        char[] array=s.toCharArray();
        int nBlockSize=(array.length/(2*nRows-2) + ((array.length%(2*nRows-2) ==0) ? 0 : 1))*(nRows-1);
        char[][] matrix=new char[nRows][nBlockSize];
        int block=0, pInBlock=0, x=0,y=0;
        for(int i=0;i<nRows;i++){
            matrix[i] = new char[nBlockSize];
        }
        for(int i=0; i<array.length; i++){
            block = i / (2*nRows-2);
            pInBlock = i % (2*nRows-2);
            x=(pInBlock < nRows) ? pInBlock : nRows-1-(pInBlock-nRows+1);
            y= block*(nRows-1)+ ((pInBlock < nRows) ? 0 : 1) * (pInBlock-nRows+1);
            matrix[x][y]=array[i];
        }
        int index=0;
        for(int i=0;i<nRows;i++){
            for(int j=0;j<nBlockSize;j++){
                if(matrix[i][j]!='\u0000'){
                    array[index]=matrix[i][j];
                    index++;
                }
            }
        }
        return String.valueOf(array);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
