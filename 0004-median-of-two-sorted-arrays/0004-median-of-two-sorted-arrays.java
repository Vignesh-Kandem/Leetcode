/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        int i=0, j=0, count=0;
        int n=(n1+n2);
        int ind2=n/2, ind1=ind2-1;
        int el1=-1, el2=-1;
        while(i<n1 && j<n2) {
            if(nums1[i]<nums2[j]) {
                if(count==ind1) el1=nums1[i];
                if(count==ind2) el2=nums1[i];
                count++;
                i++;
            }
            else {
                if(count==ind1) el1=nums2[j];
                if(count==ind2) el2=nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1) {
            if(count==ind1) el1=nums1[i];
            if(count==ind2) el2=nums1[i];
            count++;
            i++;
        }
        while(j<n2) {
            if(count==ind1) el1=nums2[j];
            if(count==ind2) el2=nums2[j];
            count++;
            j++;
        }
        if(n%2==1) return el2;
        else return (el1+el2)/2.0;
    }
}*/ //--> Better solution.

// Optimal Solution.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low=0, high=n1;
        int left=(n1+n2+1)/2;
        int n=(n1+n2);
        while(low<=high) {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(mid1-1>=0) l1=nums1[mid1-1];
            if(mid2-1>=0) l2=nums2[mid2-1];
            if(l1<=r2 && l2<=r1) {
                if(n%2==1) return Math.max(l1,l2);
                else return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return -1; 
    }
}