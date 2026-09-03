// Optimized Approach

class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int num : nums1) {
            min = Math.min(min, num);
            if (num % 2 == 1) oddCount++;
        }
        // min Element is ODD(remaining even > min) or All Even!
        return min % 2 != 0 || oddCount == 0;
    }
}