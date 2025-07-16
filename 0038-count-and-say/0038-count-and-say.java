class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char ch = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == ch) {
                    count++;
                } else {
                    current.append(count).append(ch);
                    ch = prev.charAt(j);
                    count = 1;
                }
            }
            current.append(count).append(ch);
            prev = current.toString();
        }
        return prev;
    }
}