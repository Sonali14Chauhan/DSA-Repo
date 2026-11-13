class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int k=4;
      int dp[][] = new int[n+1][k+1];
      for(int i[]: dp){
        Arrays.fill(i, -1);
      }
      return profit(prices, n, 0, k , dp);
    }

    int profit(int[] arr, int n , int i, int k, int dp[][]){
        if(i ==n) return 0;

        if(k==0) return 0;

        if(dp[i][k] != -1) return dp[i][k];

        if(k%2 == 0){
            int buy = profit(arr, n, i+1, k-1, dp) - arr[i];
            int nobuy =  profit(arr, n, i+1, k, dp);
            return dp[i][k] = Math.max(buy, nobuy);
        } else {
            int sell = profit(arr, n, i+1, k-1, dp) + arr[i];
            int nosell =  profit(arr, n, i+1, k, dp);
            return dp[i][k] = Math.max(sell, nosell);
        }
    }
}