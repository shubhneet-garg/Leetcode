class Solution {
    int[][] dp;
    public int solve(String s, int i, int j){
        if(i >= j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(s, i+1, j-1);
        }

        return dp[i][j] = 1 + Math.min(solve(s,i+1,j), solve(s,i,j-1));
    }
    public int minInsertions(String s) {
        int n = s.length();

        dp = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, n-1);
    }
}