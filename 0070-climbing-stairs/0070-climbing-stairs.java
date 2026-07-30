class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
    public int helper(int i, int n, int dp[]) {
        if(i>n) return 0;
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        int n1=helper(i+1,n,dp);
        int n2=helper(i+2,n,dp);
        dp[i]=n1+n2;
        return dp[i];
    }
}