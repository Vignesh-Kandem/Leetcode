class Solution {
    public double arrive(int dist[], int speed) {
        int n=dist.length;
        double time=0.0;
        for(int i=0;i<n-1;i++) {
            time+=Math.ceil((double)dist[i]/speed);
        }
        time+=(double)dist[n-1]/speed;
        return time;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n=dist.length;
        if(hour<=n-1) return -1;
        int low=1;
        int high=10000000;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            double val=arrive(dist,mid);
            if(val<=hour) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
}