class Solution {
    public void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp=new ArrayList<>();
        int left=low,right=mid+1;
        while (left<=mid && right<=high) {
            if (arr[left]<=arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }
        while (left<=mid)
            temp.add(arr[left++]);
        while (right<=high)
            temp.add(arr[right++]);
        for (int i=low;i<=high;i++)
            arr[i]=temp.get(i-low);
    }
    public int countpairs(int arr[], int low, int mid, int high) {
        int count=0;
        int right=mid+1;
        for(int i=low;i<mid+1;i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            count+=(right-(mid+1)); 
        }
        return count;
    }
    public int mergeSort(int[] arr, int low, int high) {
        int count=0;
		if (low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
		count+=countpairs(arr,low,mid,high);
        merge(arr, low, mid, high);
		return count;
    }
    public int reversePairs(int[] arr) {
        int n=arr.length;
        return mergeSort(arr,0,n-1);
    }
}