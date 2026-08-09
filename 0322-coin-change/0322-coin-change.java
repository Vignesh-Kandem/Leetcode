// Using Recursion.
/* class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans=helper(0,coins,amount);
        if(ans!=Integer.MAX_VALUE) return ans;
        else return -1;
    }
    public int helper(int i, int coins[], int amount) {
        if(amount==0) return 0;
        if(i>=coins.length) return Integer.MAX_VALUE;
        int include=Integer.MAX_VALUE;
        if(coins[i]<=amount) {
            include=helper(i,coins,amount-coins[i]);
            if(include!=Integer.MAX_VALUE) include++;
        }
        int exclude=helper(i+1,coins,amount);
        return Math.min(include,exclude);
    }
} */

// Using Memoization.
/* class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        int ans=helper(0,coins,amount,dp);
        if(ans!=Integer.MAX_VALUE) return ans;
        else return -1;
    }
    public int helper(int i, int coins[], int amount, int dp[][]) {
        if(amount==0) return 0;
        if(i>=coins.length) return Integer.MAX_VALUE;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int include=Integer.MAX_VALUE;
        if(coins[i]<=amount) {
            include=helper(i,coins,amount-coins[i],dp);
            if(include!=Integer.MAX_VALUE) include++;
        }
        int exclude=helper(i+1,coins,amount,dp);
        return dp[i][amount]=Math.min(include,exclude);
    }
} */

// Using Tabulation.
/* class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=1;i<=amount;i++) {
            dp[n][i]=Integer.MAX_VALUE;
        }
        for(int i=n-1;i>=0;i--) {
            for(int j=1;j<=amount;j++) {
                int exclude=dp[i+1][j];
                int include=Integer.MAX_VALUE;
                if(coins[i]<=j) {
                    if(dp[i][j-coins[i]]!=Integer.MAX_VALUE) {
                        include=dp[i][j-coins[i]]+1;
                    }
                }
                dp[i][j]=Math.min(include,exclude);
            }
        }
        if(dp[0][amount]!=Integer.MAX_VALUE) return dp[0][amount];
        else return -1;
    }
} */

// Using Tabulation(With space optimization)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int coin:coins) {
            for(int a=coin;a<=amount;a++) {
                if(dp[a-coin]!=Integer.MAX_VALUE) dp[a]=Math.min(dp[a],dp[a-coin]+1);
            }
        }
        if(dp[amount]!=Integer.MAX_VALUE) return dp[amount];
        else return -1;
    }
}