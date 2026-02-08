class Solution {
    public void findCombos(int index, int arr[], int target, List<List<Integer>> result, 
						   List<Integer> ds) {
        int n=arr.length;
		if(target==0) {
			result.add(new ArrayList<>(ds));
			return;
		}
		for(int i=index;i<n;i++) {
			if(i>index && arr[i]==arr[i-1]) continue;
			if(arr[i]>target) break;
			ds.add(arr[i]);
			findCombos(i+1,arr,target-arr[i],result,ds);
			ds.remove(ds.size()-1);
		}
	}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lst=new ArrayList<>();
		Arrays.sort(candidates);
		findCombos(0,candidates,target,lst,new ArrayList<>());
		return lst;
    }
}