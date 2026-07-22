class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<nums.length;i++) {
            if(!dq.isEmpty() && dq.getFirst()<=i-k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1) {
                ans[index++]=nums[dq.getFirst()];
            }
        }
        return ans;
    }
}