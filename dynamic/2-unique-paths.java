/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
m and n will be at most 100.
input(1,3) -> 1
input(2,3) -> 3

state: f[x][y]从起点到x,y的路径数
function: (研究倒数第一步) f[x][y] = f[x - 1][y] + f[x][y - 1]
initialize: f[0][i] = 1
            f[i][0] = 1
answer: f[n-1][m-1]

*/
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }
}