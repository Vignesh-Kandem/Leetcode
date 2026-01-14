class Solution {
    public int subArraySum(int nums[], int max) {
        int n=nums.length;
		int s=1;
		int p=0;
		for(int i=0;i<n;i++) {
			if(p+nums[i]<=max) {
				p+=nums[i];
			}
			else {
				s++;
				p=nums[i];
			}
		}
		return s;
	}
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        int maximum=Integer.MIN_VALUE;
        int sum=0;
        for(int x:nums) {
            maximum=Math.max(maximum,x);
            sum+=x;
        }
		int low=maximum;
		int high=sum;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(subArraySum(nums,mid)>k) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		return low;
    }
}