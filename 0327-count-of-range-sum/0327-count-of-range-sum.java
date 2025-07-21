class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return countWhileMergeSort(prefixSums, 0, prefixSums.length, lower, upper);
    }
    private int countWhileMergeSort(long[] sums, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;
        int mid = (left + right) / 2;
        int count = countWhileMergeSort(sums, left, mid, lower, upper) +
                    countWhileMergeSort(sums, mid, right, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[right - left];
        int r = 0;
        for (int i = left; i < mid; ++i) {
            while (k < right && sums[k] - sums[i] < lower) k++;
            while (j < right && sums[j] - sums[i] <= upper) j++;
            while (t < right && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r++] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, left, t - left);
        return count;
    }
}