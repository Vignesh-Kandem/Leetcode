class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int com[] = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        while(p1 < m && p2<n){
            if(nums1[p1] <= nums2[p2]){
                com[k++] = nums1[p1++];
            }
            else{
                com[k++] = nums2[p2++];
            }
        }
        while(p1 < m){
           com[k++] = nums1[p1++];
        }
        while(p2 < n){
           com[k++] = nums2[p2++];
        }
        if((n+m)%2!=0){
            return com[((n+m+1)/2)-1];
        }
         double res = ((com[(m+n)/2]+com[((m+n)/2)-1])/2.0);
         return res;
    }
}