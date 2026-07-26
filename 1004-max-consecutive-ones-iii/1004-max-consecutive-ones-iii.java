class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int l=0;
        int r=0;
        int zeroes=0;
        while(r<nums.length) {
            if(nums[r]==0) zeroes++;
            while(zeroes>k) {
                if(nums[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k) {
                int len=r-l+1;
                maxLen=Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
    }
}