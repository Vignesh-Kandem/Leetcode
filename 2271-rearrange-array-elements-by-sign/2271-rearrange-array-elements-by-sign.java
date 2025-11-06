class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int posIndex=1;
        int negIndex=0;
        for(int i=0;i<n;i++) {
            if(nums[i]>0) {
                res[negIndex]=nums[i];
                negIndex+=2;
            }
            else {
                res[posIndex]=nums[i];
                posIndex+=2;
            }
        }
        return res;
    }
}