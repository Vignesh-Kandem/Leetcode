class Solution {
    public int lengthOfLongestSubstring(String s) {
     int n = s.length();
     int l = 0;
     int r = 0;
     int maxLen = 0;
     HashSet<Character> hs = new HashSet<>();
     while(r<n){
       if(hs.contains(s.charAt(r))){
          hs.remove(s.charAt(l));
          l++;
       }
       else{
        hs.add(s.charAt(r));
        int length = r - l +1;
        maxLen = Math.max(maxLen , length);
        r++;
       }
     }
     return maxLen;
    }     
}