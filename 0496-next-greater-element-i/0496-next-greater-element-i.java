class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=n2-1;i>=0;i--) {
            while(!st.isEmpty() && st.peek()<=nums2[i]) {
                st.pop();
            }
            if(st.isEmpty()) map.put(nums2[i],-1);
            else map.put(nums2[i],st.peek());
            st.push(nums2[i]);
        }
        int nge[]=new int[n1];
        for(int i=0;i<n1;i++) {
            nge[i]=map.get(nums1[i]);
        }
        return nge;
    }
}