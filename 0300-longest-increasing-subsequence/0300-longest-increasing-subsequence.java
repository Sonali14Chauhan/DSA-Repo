
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i[] :  dp){
            Arrays.fill(i, -1);
        }
        return LIS(nums, n, 0, -1, dp);
    }

    int LIS(int a[], int n, int i, int prev, int dp[][]) {

        if (i == n) {
            return 0;
        }

        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }

        int nopick = LIS(a, n, i + 1, prev, dp);

        int pick = 0;

        if (prev == -1 || a[i] > a[prev]) {
            pick = 1 + LIS(a, n, i + 1, i, dp);
        }

        return dp[i][prev+1] = Math.max(pick, nopick);
    }
}
