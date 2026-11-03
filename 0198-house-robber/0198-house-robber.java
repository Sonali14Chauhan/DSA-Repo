class Solution {
    public int rob(int[] nums) {
        int[][] dp= new int[nums.length][2];
        for(int[] i : dp){
            Arrays.fill(i, -1);
         }

     return house(nums, 1, 0, dp);   
    }
    int house(int[] num, int free, int i, int[][] dp){
        if(i >= num.length) return 0;

        if(dp[i][free] != -1) return dp[i][free];

        if(free == 0){
            return dp[i][free] = house(num, 1, i+1, dp);
        }

        int pick = num[i] + house(num, 0, i+1, dp);
        int nopick = house(num,1, i+1, dp);

        return dp[i][free] = Math.max(pick, nopick);
    }
}