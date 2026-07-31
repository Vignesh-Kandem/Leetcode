class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            dq.addLast(i);
        }
        while(dq.size()>1) {
            for(int count=1;count<k;count++) {
                dq.addLast(dq.removeFirst());
            }
            dq.removeFirst();
        }
        return dq.peekFirst();
    }
}