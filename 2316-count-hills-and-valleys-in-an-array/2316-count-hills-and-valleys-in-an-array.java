class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        List<Integer> unique = new ArrayList<>();
        unique.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                unique.add(nums[i]);
            }
        }
        for (int i = 1; i < unique.size() - 1; i++) {
            int prev = unique.get(i - 1);
            int curr = unique.get(i);
            int next = unique.get(i + 1);

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                count++;
            }
        }
        return count;
    }
}