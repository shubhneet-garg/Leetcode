class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c+2];

        arr[0] = 0;
        arr[c+1] = n;

        for(int i=0;i<c;i++){
            arr[i+1] = cuts[i];
        }

        Arrays.sort(arr);

        int[][] dp = new int[c+2][c+2];

        for(int i=c;i>=0;i--){
            for(int j=i+1;j<c+2;j++){

                if (j - i == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int cost = arr[j] - arr[i] + dp[i][k] + dp[k][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][c+1];
    }
}