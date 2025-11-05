class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int maxi=0,count=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) {
                count++;
                if(maxi<count) maxi=count;
            }
            else count=0;
        }
        return maxi;
    }
}