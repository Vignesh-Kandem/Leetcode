class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st=new HashSet<>(wordList);
        if(!st.contains(endWord)) return 0;
        Deque<String> dq=new ArrayDeque<>();
        dq.offer(beginWord);
        int level=1;
        while(!dq.isEmpty()) {
            int size=dq.size();
            for(int i=0;i<size;i++) {
                String word=dq.poll();
                if(word.equals(endWord)) return level;
                char[] arr=word.toCharArray();
                for(int j=0;j<arr.length;j++) {
                    char original=arr[j];
                    for(char c='a';c<='z';c++) {
                        arr[j]=c;
                        String newWord=new String(arr);
                        if(st.contains(newWord)) {
                            dq.offer(newWord);
                            st.remove(newWord);
                        }
                    }
                    arr[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}