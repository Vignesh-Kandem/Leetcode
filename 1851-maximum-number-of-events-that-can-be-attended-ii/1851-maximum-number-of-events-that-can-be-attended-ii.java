import java.util.*;
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        Integer[][] dp = new Integer[n][k + 1];
        return dfs(0, k, events, dp);
    }
    private int dfs(int index, int remaining, int[][] events, Integer[][] dp) {
        if (index == events.length || remaining == 0) return 0;
        if (dp[index][remaining] != null) return dp[index][remaining];
        int skip = dfs(index + 1, remaining, events, dp);
        int nextIndex = binarySearch(events, events[index][1] + 1);
        int take = events[index][2] + dfs(nextIndex, remaining - 1, events, dp);
        return dp[index][remaining] = Math.max(skip, take);
    }
    private int binarySearch(int[][] events, int target) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
