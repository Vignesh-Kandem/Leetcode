class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+2];
        dp[n+1]=0;
        dp[n]=0;
        for(int i=n-1;i>=0;i--) {
            int include=nums[i]+dp[i+2];
            int exclude=dp[i+1];
            dp[i]=Math.max(include,exclude);
        }
        return dp[0];
    }
}