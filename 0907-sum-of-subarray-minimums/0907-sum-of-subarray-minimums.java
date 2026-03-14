class Solution {
    public int[] findNSE(int n, int arr[]) {
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSEE(int n, int arr[]) {
		int psee[]=new int[n];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) psee[i]=-1;
			else psee[i]=st.peek();
			st.push(i);
		}
		return psee;
	}
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int nse[]=findNSE(n,arr);
        int psee[]=findPSEE(n,arr);
        int mod=1000000007;
        long sum=0;
        for(int i=0;i<n;i++) {
            long left=i-psee[i];
            long right=nse[i]-i;
            sum=(sum+(right*left%mod*arr[i]%mod))%mod;
        }
        return (int)sum;
    }
}