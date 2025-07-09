class Solution {
    public static void getPermute(int nums[] , List<List<Integer>> ans, List<Integer> cur, int val[]){
        if(nums.length == cur.size()){
            ans.add(new ArrayList<>(cur));
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
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int val[] = new int[n];
        getPermute(nums, ans, new ArrayList<>(),val);
        return ans;
    }
}