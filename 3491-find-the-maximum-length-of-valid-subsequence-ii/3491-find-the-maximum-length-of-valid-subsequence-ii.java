class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int before = 0; before < k; before++) {
                dp[before][num] = dp[num][before] + 1;
                res = Math.max(res, dp[before][num]);
            }
        }
        return res;
    }
}