class Solution {
    public int howManyDays(int[] weights, int capacity) {
        int n=weights.length;
        int days=1;
        int load=0;
        for(int i=0;i<n;i++) {
            int val=weights[i]+load;
            if(val>capacity) {
                days++;
                load=weights[i];
            }
            else {
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maximum=Integer.MIN_VALUE;
        int sum=0;
        for(int x:weights) {
            maximum=Math.max(maximum,x);
            sum+=x;
        }
        int low=maximum;
        int high=sum;
        while(low<=high) {
            int mid=(low+high)/2;
            if(howManyDays(weights,mid)<=days) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}