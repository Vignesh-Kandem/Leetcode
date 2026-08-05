// Recursion.
/* class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    public int helper(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) return 1;
        if(i>m-1 || j>n-1) return 0;
        int right=helper(i,j+1,m,n);
        int down=helper(i+1,j,m,n);
        return right+down;
    }
} */

// Memoization.
/* class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,0,m,n,dp);
    }
    public int helper(int i, int j, int m, int n, int dp[][]) {
        if(i==m-1 && j==n-1) return 1;
        if(i>m-1 || j>n-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=helper(i,j+1,m,n,dp);
        int down=helper(i+1,j,m,n,dp);
        return dp[i][j]=right+down;
    }
} */

// Tabulation.
/* class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 && j==n-1) continue;
                int right=0;
                int down=0;
                if(j+1<n) right=dp[i][j+1];
                if(i+1<m) down=dp[i+1][j];
                dp[i][j]=right+down;
            }
        }
        return dp[0][0];
    }
} */

// Tabulation(With space optimization).
class Solution {
    public int uniquePaths(int m, int n) {
        int prev[]=new int[n];
        prev[n-1]=1;
        for(int i=m-1;i>=0;i--) {
            int curr[]=new int[n];
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 && j==n-1) {
                    curr[j]=1;
                    continue;
                }
                int right=0;
                int down=0;
                if(j+1<n) right=curr[j+1];
                down=prev[j];
                curr[j]=right+down;
            }
            prev=curr;
        }
        return prev[0];
    }
}