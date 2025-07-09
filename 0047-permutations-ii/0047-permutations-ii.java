class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();
    public  void getPermute(int nums[] , List<List<Integer>> ans, List<Integer> cur, int val[]){
        if(nums.length == cur.size()){
            if(!hs.contains(cur)){
                ans.add(new ArrayList<>(cur));
                hs.add(cur);
            }
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(val[i] == 0){
                cur.add(nums[i]);
                val[i]=1;
                getPermute(nums , ans , cur, val);
                cur.remove(cur.size()-1);
                val[i] = 0;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
         int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int val[] = new int[n];
        getPermute(nums, ans, new ArrayList<>(),val);
        return ans;
    }
}