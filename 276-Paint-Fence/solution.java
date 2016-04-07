public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[3];
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[getIndex(i)] = k;
            }else if(i == 2){
                dp[getIndex(i)] = k * k;
            }else{
                dp[getIndex(i)] = (k - 1) * (dp[getIndex(i - 2)] + dp[getIndex(i - 1)]);
            }
        }
        return dp[getIndex(n)];
    }
    private int getIndex(int n){
        return n % 2 == 0 ? 2 : n % 2;
    }
}

/*
Consider posts from 1 ~ n. Now we look at last post, marked n:
S(n) means: last 2 fence posts have same color.
    Note: S(n) will equal to whatever that's on n-1 position.
    Also, just because n and n-1 are same, that means n-2 and n-1 have to be differnet.
SO:
S(n) = D(n - 1)
D(n) means: last 2 fence posts have different color, so (k - 1)
D(n) = (k - 1) * (D(n - 1) + S(n - 1)) = (k-1) * (D(n - 1) + D(n - 2))
*/