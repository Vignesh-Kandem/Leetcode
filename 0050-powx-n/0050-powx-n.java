class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double ans=1.0;
        long power=n;
        if(power<0) power=-power;
        while(power>0) {
            if(power%2==1) {
                ans=ans*x;
                power=power-1;
            }
            else {
                x=x*x;
                power=power/2;
            }
        }
        if(n<0) ans=1.0/ans;
        return ans;
    }
}