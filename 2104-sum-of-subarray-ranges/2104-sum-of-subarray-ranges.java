class Solution {
    /* The three functions used to find sum of subarray minimums.
       1. nextSmaller, 2. prevSmallerEqual, 3. sumSubarrayMins  */
    public int[] nextSmaller(int n, int arr[]) {
        int nse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] prevSmallerEqual(int n, int arr[]) {
        int pse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public long sumSubarrayMins(int n, int arr[]) {
        int nse[]=nextSmaller(n,arr);
        int pse[]=prevSmallerEqual(n,arr);
        long sum=0;
        for(int i=0;i<n;i++) {
            long left=i-pse[i];
            long right=nse[i]-i;
            sum+=left*right*arr[i];
        }
        return sum;
    }
    /* The three functions used to find sum of subarray maximums.
	   1. nextGreater, 2. prevGreaterEqual, 3. sumSubarrayMaxs  */
    public int[] nextGreater(int n, int arr[]) {
        int nge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]) {
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }
    public int[] prevGreaterEqual(int n, int arr[]) {
        int pge[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && arr[st.peek()]<arr[i]) {
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
    public long sumSubarrayMaxs(int n, int arr[]) {
        int nge[]=nextGreater(n,arr);
        int pge[]=prevGreaterEqual(n,arr);
        long sum=0;
        for(int i=0;i<n;i++) {
            long left=i-pge[i];
            long right=nge[i]-i;
            sum+=left*right*arr[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        return sumSubarrayMaxs(n,nums)-sumSubarrayMins(n,nums);
    }
}