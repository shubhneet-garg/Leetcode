class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int c=1;c<=k;c++){
                    if(buy == 1){
                        dp[i][buy][c] = Math.max(-prices[i] + dp[i+1][0][c], dp[i+1][1][c]);
                    }else{
                        dp[i][buy][c] = Math.max(prices[i] + dp[i+1][1][c-1], dp[i+1][0][c]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}