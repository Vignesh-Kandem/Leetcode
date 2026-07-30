// Using Memoization...
/* class Solution {
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
} */

// Using Tabulation...
/* class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+2];
        dp[n+1]=0;
        dp[n]=1;
        for(int i=n-1;i>=0;i--) {
            int n1=dp[i+1];
            int n2=dp[i+2];
            dp[i]=n1+n2;
        }
        return dp[0];
    }
} */

// Using Tabulation(With Space optimization)...
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int prev2=1;
        int prev=2;
        for(int i=3;i<=n;i++) {
            int current=prev+prev2;
            prev2=prev;
            prev=current;
        }
        return prev;
    }
}