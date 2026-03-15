import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        ArrayList<Integer> st=new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr=asteroids[i];
            while(!st.isEmpty() && curr<0 &&
                  st.get(st.size()-1)>0 && st.get(st.size()-1)<Math.abs(curr)) {
                st.remove(st.size()-1);
            }
            if(!st.isEmpty() && curr<0 && st.get(st.size()-1)>0 && 
               st.get(st.size()-1)==Math.abs(curr)) {
                st.remove(st.size()-1);
            }
            else if(st.isEmpty() || curr>0 || st.get(st.size()-1)<0) {
                st.add(curr);
            }
        }
        int result[]=new int[st.size()];
        for(int i=0;i<st.size();i++) {
            result[i]=st.get(i);
        }
        return result;
    }
}