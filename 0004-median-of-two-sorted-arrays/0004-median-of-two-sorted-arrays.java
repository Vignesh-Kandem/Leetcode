class Solution {
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
}