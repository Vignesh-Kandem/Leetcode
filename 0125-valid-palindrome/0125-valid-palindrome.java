class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        return check(s, 0, s.length()-1);
    }
    private boolean check(String s, int l, int r) {
        if (l>=r) {
            return true;
        }
        char cL = s.charAt(l);
        char cR=s.charAt(r);
        if (!Character.isLetterOrDigit(cL)) {
            return check(s, l+1, r);
        }
        if (!Character.isLetterOrDigit(cR)) {
            return check(s, l, r-1);
        }
        if (cL!=cR) {
            return false;
        }
        return check(s, l+1, r-1);
    }
}
