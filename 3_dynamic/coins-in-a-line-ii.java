public class Solution{ 
    public boolean firstWillWin(int[] values){
        int n = values.length;
        if(n == 0){
            return false;
        }else if(n == 1){
            return true;
        else if(n == 2){ 
            return true;
        }
        int[] sum = new int[n + 1]; //sum[i]表示后i个硬币的总和
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + values[n - i];
        }
        //state
        int[] f = new int[n + 1]; //f[i]表示还剩i个硬币, 当前选手最多取得的价值
        //init
        f[0] = 0;
        f[1] = values[n - 1];
        f[2] = values[n - 1] + values[n - 2];
        //function
        for(int i = 3; i <= n; i++){
            f[i] = sum[i] - Math.min(f[i - 1], f[i - 2]); //让后手拿的越少, 先手就越多
        }
        //result
        return f[n] > sum[n] / 2;
    }
}

public class Solution {
    public boolean firstWillWin(int[] values) {
        int []dp = new int[values.length + 1]; //还剩i个硬币, 现在先手取硬币的人最后最多取得的硬币价值
        boolean[] flag =new boolean[values.length + 1];
        int sum = 0;
        for(int now : values){
            sum += now;
        }
        return sum < 2 * MemorySearch(values.length, dp, flag, values);
    }
    int MemorySearch(int n, int []dp, boolean []flag, int []values) { 
        if(flag[n] == true){
            return dp[n];
        }
        if(n == 0)  {
            dp[n] = 0;  
        } else if(n == 1) {
            dp[n] = values[values.length - 1];
        } else if(n == 2) {
            dp[n] = values[values.length - 1] + values[values.length - 2]; 
        } else if(n == 3){
            dp[n] = values[values.length - 2] + values[values.length - 3]; 
        } else {
            dp[n] = Math.max(
                Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length - n],
                Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length - n] + values[values.length - n + 1]
                );
        }
        flag[n] = true;
        return dp[n];
    }
}


public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[] dp = new int[n + 1];//dp[i]表示还剩下i个硬币可取时, 现在当前取硬币的人最后最多取的硬币价值, dp[0]是我们想要的最后结果, 表示剩下0个硬币(都取完了), 在此时当前取硬币的人最后最多取的硬币价值
        boolean []flag =new boolean[n + 1];  //dp[n]表示还剩下n个硬币呢, 一个硬币都没拿, 所以此时这个人取得的硬币价值是0, dp[n-1], 说明这个人取了1个了, 最大价值就是第一个硬币
        int[] sum = new int[n + 1]; // sum[i]表示从第i个硬币到最后一个的总价值
        sum[n-1] = values[n-1];
        for(int i = n-2; i >= 0; i--) { 
            sum[i] += sum[i+1] + values[i]; 
        }
        return sum[0] / 2 < MemorySearch(0, n, dp, flag, values, sum);
    }
    int MemorySearch(int i, int n, int []dp, boolean []flag, int []values, int []sum) {
        if(flag[i] == true){
            return dp[i];
        }
        if(i == n){
            dp[n] = 0;  
        } else if(i == n-1) {
            dp[i] = values[i];
        } else if(i == n-2) {
            dp[i] = values[i] + values[i + 1]; 
        } else {
            dp[i] = sum[i] -
                Math.min(MemorySearch(i+1, n, dp, flag, values, sum) , MemorySearch(i+2, n, dp, flag, values, sum));
                // 把dp[n], 问题转化成dp[n-1]和dp[n-2]问题
        }
        flag[i] = true;
        return dp[i];
    }
}




//草稿本上有dp推倒过程


/*
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until 
there are no more coins left. 
The player who take the coins with the most value wins.
Could you please decide the first player will win or lose?
Given values array A = [1,2,2], return true.
Given A = [1,2,4], return false.
*/

