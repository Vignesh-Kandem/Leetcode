class Solution {
    public long totalHours(int[] piles, int hourly) {
        int n=piles.length;
        long totalhrs=0;
        for(int i=0;i<n;i++) {
            totalhrs+=(piles[i]+(long)hourly-1)/hourly;
        }
        return totalhrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=Integer.MIN_VALUE;
        for(int x:piles) {
            max=Math.max(max,x);
        }
        int low=1;
        int high=max;
        while(low<=high) {
            int mid=low+(high-low)/2;
            long reqTime=totalHours(piles,mid);
            if(reqTime<=h) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}