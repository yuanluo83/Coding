package com.leetcode.oj;

public class NumberofIslands {
	int m=0, n=0;
    int count=0;
    public int numIslands(char[][] grid) {
        m=grid.length;
        if(m==0){
            return 0;
        }
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    mark(i,j,grid);
                }
            }
        }
        return count;
    }
    
    public void mark(int i, int j, char[][] grid){
        if(i==-1||i==m||j==-1||j==n||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        mark(i-1,j,grid);
        mark(i,j-1,grid);
        mark(i+1,j,grid);
        mark(i,j+1,grid);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(new NumberofIslands().numIslands(grid));
	}

}
