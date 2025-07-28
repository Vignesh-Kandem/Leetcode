class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            int mask = 1 << i;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    bitCount++;
                }
            }
            if (bitCount % 3 != 0) {
                result |= mask;
            }
        }       
        return result;
    }
}