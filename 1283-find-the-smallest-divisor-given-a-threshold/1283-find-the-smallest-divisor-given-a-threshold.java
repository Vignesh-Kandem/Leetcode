class Solution {
    public long sumByDigits(int nums[], int div) {
        int n=nums.length;
        long sum=0;
        for(int i=0;i<n;i++) {
            sum+=(nums[i]+div-1)/div;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int maximum=Integer.MIN_VALUE;
        for(int x:nums) {
            maximum=Math.max(maximum,x);
        }
        int low=1;
        int high=maximum;
        while(low<=high) {
            int mid=(low+high)/2;
            if(sumByDigits(nums,mid)<=threshold) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}