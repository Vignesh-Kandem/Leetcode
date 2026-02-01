class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        if(n<3) return -1;
        int sub[]=new int[n];
        sub[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) {
            sub[i]=Math.min(nums[i],sub[i+1]);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=n-2;i++) {
            int cost=nums[0]+nums[i]+sub[i+1];
            ans=Math.min(ans,cost);
        }
        return ans;
    }
}