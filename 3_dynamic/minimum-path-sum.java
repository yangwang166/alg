public class Solution {
    public int minPathSum(int[][] grid) {
        //corner case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        //state
        int[][] f = new int[M][N];//f[x][y]表示从起点[0][0]走到[x][y]的最短路径
        //init
        f[0][0] = grid[0][0];
        for (int i = 1; i < M; i++){
          f[i][0] = f[i - 1][0] + grid[i][0]; //初始化矩阵左边的路径和
        }
        for (int i = 1; i < N; i++){
          f[0][i] = f[0][i - 1] + grid[0][i]; //初始化矩阵上边的路径和
        }
        //function
        for (int i = 1; i < M; i++) { 
            for (int j = 1; j < N; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        //result
        return f[M - 1][N - 1];
    }
}

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
You can only move either down or right at any point in time.

state:     f[x][y]从起点走到x,y的最短路径
function:  f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
intialize: f[i][0] = sum(0,0 ~ i,0)
           f[0][i] = sum(0,0 ~ 0,i)
answer:    f[n-1][m-1]
*/
