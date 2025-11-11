class Solution {
    void swapIfGreater(int[] nums1, int[] nums2, int index1, int index2) {
        if(nums1[index1]>nums2[index2]) {
            int temp=nums1[index1];
          nums1[index1]=nums2[index2];
          nums2[index2]=temp;
        }
    }
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int len=(n+m);
        int gap=(len/2)+(len%2);
        while(gap>0) {
            int left=0;
            int right=left+gap;
            while(right<len) {
                // nums1[] and nums2[]
                if(left<n && right>=n) {
                    swapIfGreater(nums1,nums2,left,right-n);
                }
                // nums2[] and nums2[]
                else if(left>=n) {
                    swapIfGreater(nums2,nums2,left-n,right-n);
                }
                // nums1[] and nums1[]
                else {
                    swapIfGreater(nums1,nums1,left,right);
                }
                left++;
                right++;
            }
            if(gap==1) break;
			gap=(gap/2)+(gap%2);
        }
        for(int i=0;i<m;i++) {
            nums1[n+i]=nums2[i];
        }
    }
}