class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
