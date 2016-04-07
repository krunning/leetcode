public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[2][k];
        for(int i = 0; i < k; i ++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i++){
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                int cur = dp[(i - 1) % 2][j];
                if(cur < min1){
                    min2 = min1;
                    min1 = cur;
                }else if(cur < min2){
                    min2 = cur;
                }
            }
            for(int j = 0; j < k; j ++){
                dp[i % 2][j] = dp[(i - 1) % 2][j] == min1 ? costs[i][j] + min2 : costs[i][j] + min1;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            res = Math.min(res, dp[(n - 1) % 2][i]);
        }
        return res;
    }
}
/*
Define DP[i][j] as the total minimum cost for previous i - 1 hourses and paint current house as j color;
*/