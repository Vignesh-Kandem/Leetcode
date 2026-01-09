class Solution {
    public int search(int[] nums, int low, int high, int target) {
        if(low>high) return -1;
        int mid=(low+(high-low)/2);
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return search(nums,mid+1,high,target);
        return search(nums,low,mid-1,target);
    }
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }
}