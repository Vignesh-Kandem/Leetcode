class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int ans[]=new int[n];
        for(int i=0;i<n;i++) {
            int target=nums.get(i);
            if(target==2) {
                ans[i]=-1;
                continue;
            }
            int x=-1;
            for(int j=target-1;j>=0;j--) {
                if((j|(j+1))==target) {
                    x=j;
                }
            }
            ans[i]=x;
        }
        return ans;
    }
}