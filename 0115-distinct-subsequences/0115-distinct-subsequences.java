class Solution {
    int[][] dp;
    public int solve(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(s, t, i+1, j+1) + solve(s, t, i+1, j);
        }else{
            return dp[i][j] = solve(s, t, i+1, j);
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s, t, 0, 0);
    }
}