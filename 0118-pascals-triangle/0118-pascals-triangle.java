class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            long val=1;
            List<Integer> ansRow=new ArrayList<>();
            ansRow.add(1);
            for(int col=1;col<i;col++) {
                val=val*(i-col);
                val=val/col;
                ansRow.add((int)val);
            }
            ans.add(ansRow);
        }
        return ans;
    }
}