// Using Recursion.
/* class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        return checkPossible(0,nums,target);
    }
    public boolean checkPossible(int i, int nums[], int target) {
        if(target==0) return true;
        if(i>=nums.length) return false;
        if(nums[i]<=target) {
            if(checkPossible(i+1,nums,target-nums[i])) return true;
        }
        return checkPossible(i+1,nums,target);
    }
} */

// Using Memoization.
/* class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        Boolean dp[][]=new Boolean[n][target+1];
        return checkPossible(0,nums,target,dp);
    }
    public boolean checkPossible(int i, int nums[], int target, Boolean dp[][]) {
        if(target==0) return true;
        if(i>=nums.length) return false;
        if(dp[i][target]!=null) return dp[i][target];
        boolean include=false;
        if(nums[i]<=target) {
            include=checkPossible(i+1,nums,target-nums[i],dp);
        }
        boolean exclude=checkPossible(i+1,nums,target,dp);
        dp[i][target]=include||exclude;
        return dp[i][target];
    }
} */

// Using Tabulation.
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++) {
            dp[i][0]=true;
        }
        for(int i=n-1;i>=0;i--) {
            for(int t=1;t<=target;t++) {
                boolean include=false;
                if(nums[i]<=t) {
                    include=dp[i+1][t-nums[i]];
                }
                boolean exclude=dp[i+1][t];
                dp[i][t]=include||exclude;
            }
        }
        return dp[0][target];
    }
}