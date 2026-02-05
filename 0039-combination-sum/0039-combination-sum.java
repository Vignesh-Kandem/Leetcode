class Solution {
    public void findCombo(int cand[],int tar,List<List<Integer>> res,List<Integer> ds,
                               int index) {
        int n=cand.length;
        if(index==n) {
            if(tar==0) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }    
        if(cand[index]<=tar) {
            ds.add(cand[index]);
            findCombo(cand,tar-cand[index],res,ds,index);
            ds.remove(ds.size()-1);
        }
        findCombo(cand,tar,res,ds,index+1);
    }
    public List<List<Integer>> combinationSum(int[] cand, int tar) { 
        List<List<Integer>> res = new ArrayList<>();
        findCombo(cand,tar,res,new ArrayList<>(),0);
        return res;
    }
}