/*
 * 64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 */
package algorithms;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid.length==0 || grid[0].length==0){
            return 0;
        }
        // We only need one-dimensional array to store temp sum results, as we scan the 2d array line by line.
        int[] sum = new int[grid[0].length];
        sum[0] = grid[0][0];
        for (int j=1;j<grid[0].length;j++){
            sum[j] = sum[j-1] + grid[0][j];
        }
        for (int i=1;i<grid.length;i++){
            sum[0] = sum[0] + grid[i][0];
            for (int j=1;j<grid[0].length;j++){
                sum[j] = Math.min(sum[j-1], sum[j]) + grid[i][j];
            }
        }
        return sum[grid[0].length-1];
    }
}
