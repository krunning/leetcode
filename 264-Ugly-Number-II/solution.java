public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int f2 = 2, f3 = 3, f5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        int min = 0;
        for(int i = 1; i < n; i++){
            min = Math.min(Math.min(f3, f5), f2);
            dp[i] = min;
            if(min == f2) f2 = 2 * dp[++ i2];
            if(min == f3) f3 = 3 * dp[++ i3];
            if(min == f5) f5 = 5 * dp[++ i5];
        }
        return dp[n - 1];
    }
}