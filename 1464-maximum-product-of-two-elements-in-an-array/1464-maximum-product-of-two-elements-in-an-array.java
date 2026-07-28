class Solution {
    public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp=new int[high-low+1];
        int left=low, right=mid+1;
		int index=0;
        while(left<=mid && right<=high) {
            if(nums[left]<=nums[right]) {
				temp[index++]=nums[left++];
			}
            else {
				temp[index++]=nums[right++];
			}
        }
        while(left<=mid) {
			temp[index++]=nums[left++];
		}
        while(right<=high) {
			temp[index++]=nums[right++];
		}
        for(int i=low;i<=high;i++) {
			nums[i]=temp[i-low];
		}
    }
    public static void mergeSort(int[] nums, int low, int high) {
        if (low>=high) return;
        int mid=(low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public int maxProduct(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        int x=nums[nums.length-1]-1;
        int y=nums[nums.length-2]-1;
        return x*y;
    }
}