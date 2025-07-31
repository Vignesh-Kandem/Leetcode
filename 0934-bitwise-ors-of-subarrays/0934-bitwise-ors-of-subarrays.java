class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            Set<Integer> cur2 = new HashSet<Integer>();
            Iterator<Integer> it = cur.iterator();
            while (it.hasNext()) {
                int y = it.next();
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}