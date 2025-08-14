class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);
            if (c1 == c2 && c2 == c3) {
                String current = num.substring(i, i + 3);
                if (maxGood.equals("") || current.compareTo(maxGood) > 0) {
                    maxGood = current;
                }
            }
        }        
        return maxGood;
    }
}