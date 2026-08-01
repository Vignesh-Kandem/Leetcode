class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--) {
            int ans1=costs[0]+dp[i+1];
            int j=i;
            while(j<n && days[j]<days[i]+7) j++;
            int ans2=costs[1]+dp[j];
            j=i;
            while(j<n && days[j]<days[i]+30) j++;
            int ans3=costs[2]+dp[j];
            dp[i]=Math.min(ans1,Math.min(ans2,ans3));
        }
        return dp[0];
    }
}