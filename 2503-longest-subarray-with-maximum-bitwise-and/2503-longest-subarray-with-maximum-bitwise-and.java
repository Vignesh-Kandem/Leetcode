class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, ans = 0, currentStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (maxVal < num) {
                maxVal = num;
                ans = currentStreak = 0;
            }
            if (maxVal == num) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }
            ans = Math.max(ans, currentStreak);
        }
        return ans;
    }
}