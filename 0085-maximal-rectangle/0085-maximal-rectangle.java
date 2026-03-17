class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && heights[st.peek()]>heights[i]) {
                int element=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea,(heights[element]*(nse-pse-1)));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int nse=n;
            int element=st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(maxArea,(heights[element]*(nse-pse-1)));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxi=0;
        int height[]=new int[m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            int area=largestRectangleArea(height);
            maxi=Math.max(maxi,area);
        }
        return maxi;
    }
}