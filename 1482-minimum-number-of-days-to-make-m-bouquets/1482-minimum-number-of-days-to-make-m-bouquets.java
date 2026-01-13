class Solution {
    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int n=bloomDay.length;
        int count=0;
        int noofB=0;
        for(int i=0;i<n;i++) {
            if(bloomDay[i]<=day) {
                count++;
            }
            else {
                noofB+=(count/k);
                count=0;
            }
        }
        noofB+=(count/k);
        if(noofB>=m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int minimum=Integer.MAX_VALUE;
        int maximum=Integer.MIN_VALUE;
        for(int x:bloomDay) {
            minimum=Math.min(minimum,x);
            maximum=Math.max(maximum,x);
        }
        int low=minimum;
        int high=maximum;
        while(low<=high) {
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)==true) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}