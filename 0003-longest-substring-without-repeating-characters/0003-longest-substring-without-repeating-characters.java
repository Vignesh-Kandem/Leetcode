class Solution {
    public int lengthOfLongestSubstring(String s) {
/*
        int maxLength = 0;
         int n = s.length();

         for(int i = 0;i<n;i++) 
         {
             boolean visited[] = new boolean[256];
             for(int j = i;j<n;j++)
             {
                 if(visited[s.charAt(j)])
                 {
                     break;
                 }
                 visited[s.charAt(j)] = true;
                 maxLength = Math.max(maxLength, j - i + 1);              
             }
          
         }
         return maxLength;
        
        
         Map<Character, Integer> hash = new HashMap<>();
         int n = s.length();
         int l = 0;
         int r = 0;
         int maxLen = 0;
         while(r<n){
             if(hash.containsKey(s.charAt(r)) && hash.get(s.charAt(r)) >= l){
                 l = hash.get(s.charAt(r)) + 1;
             }
             int len  = r-l+1;
             maxLen = Math.max(len, maxLen);
             hash.put(s.charAt(r), r);
             r++;
          }
        return maxLen;
*/     

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