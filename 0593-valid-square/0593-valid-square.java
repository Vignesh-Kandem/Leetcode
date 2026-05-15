import java.util.*;
class Solution {
    public int square(int a[], int b[]) {
        int x=(a[0]-b[0])*(a[0]-b[0]);
        int y=(a[1]-b[1])*(a[1]-b[1]);
        return x+y;
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> st=new HashSet<>();
        st.add(square(p1,p2));
        st.add(square(p2,p3));
        st.add(square(p3,p4));
        st.add(square(p4,p1));
        st.add(square(p1,p3));
        st.add(square(p2,p4));
        if(!st.contains(0) && st.size()==2) {
            return true;
        }
        return false;
    }
}