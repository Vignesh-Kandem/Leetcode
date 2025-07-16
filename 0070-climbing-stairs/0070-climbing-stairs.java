class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int oSB = 2; //oneStepBefore
        int tSB = 1; //twoStepsBefore
        int allWays = 0;
        for (int i = 3; i <= n; i++) {
            allWays = oSB + tSB;
            tSB = oSB;
            oSB = allWays;
        }
        return allWays;
    }
}