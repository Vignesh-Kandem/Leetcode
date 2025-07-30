class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, a = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (maxVal < num) {
                maxVal = num;
                a = c = 0;
            }
            if (maxVal == num) {
                c++;
            } else {
                c = 0;
            }
            a = Math.max(a,c);
        }
        return a;
    }
}