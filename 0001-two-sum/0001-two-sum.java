public class Solution{
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int a=nums[i];
            int more=target-a;
            if(map.containsKey(more)) {
                return new int[] {map.get(more),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}