class Solution {
    static HashSet<List<Integer>> hs = new HashSet<>();
    public void combinationSum(int cand[] , int tar , List<List<Integer>> res , List<Integer> cur , int ind){
            int n = cand.length;
            if(ind == n || tar<0) return;
            if(tar == 0) {
                if(!hs.contains(cur)) {
                Collections.sort(new ArrayList<>(cur));
                    hs.add(cur); 
                    res.add(new ArrayList<>(cur));
                }
                return;
            }
            cur.add(cand[ind]);
            combinationSum(cand , tar-cand[ind] , res , cur ,ind+1);
            combinationSum(cand , tar-cand[ind] , res , cur,  ind);
            cur.remove(cur.size()-1);
            combinationSum(cand , tar , res , cur , ind+1);
    }
    public List<List<Integer>> combinationSum(int[] cand, int tar) { 
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(cand , tar , res , new ArrayList<>() , 0);
        return res;
    }
}