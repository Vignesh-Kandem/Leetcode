// Recursion.
/* class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        return solve(0,0,n,triangle);
    }
    public int solve(int i, int j, int n, List<List<Integer>> triangle) {
        if(i==n-1) return triangle.get(i).get(j);
        int down=solve(i+1,j,n,triangle);
        int diagonal=solve(i+1,j+1,n,triangle);
        return triangle.get(i).get(j)+Math.min(down,diagonal);
    }
} */

// Memoization.
/* class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i[]:dp) Arrays.fill(i,-1);
        return solve(0,0,n,triangle,dp);
    }
    public int solve(int i, int j, int n, List<List<Integer>> triangle, int dp[][]) {
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down=solve(i+1,j,n,triangle,dp);
        int diagonal=solve(i+1,j+1,n,triangle,dp);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(down,diagonal);
    }
} */

// Tabulation.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int b=0;b<n;b++) dp[n-1][b]=triangle.get(n-1).get(b);
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                int down=dp[i+1][j];
                int diagonal=dp[i+1][j+1];
                dp[i][j]=triangle.get(i).get(j)+Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
}