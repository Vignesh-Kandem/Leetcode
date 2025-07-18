class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        long[] prefix = new long[len];
        long[] suffix = new long[len];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (i >= n - 1) {
                prefix[i] = leftSum;
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = len - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (i <= 2 * n) {
                suffix[i] = rightSum;
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            res = Math.min(res, prefix[i] - suffix[i + 1]);
        }
        return res;
    }
}