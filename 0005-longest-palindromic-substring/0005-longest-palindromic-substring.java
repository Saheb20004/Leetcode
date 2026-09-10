class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        // Edge case
        if (n <= 1) {
            return s;
        }

        // dp[left][right]
        // null  -> not calculated
        // true  -> palindrome
        // false -> not palindrome
        Boolean[][] dp = new Boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // Try every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j, dp)) {
                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int left, int right, Boolean[][] dp) {

        // Base case
        if (left >= right) {
            return true;
        }

        // Already calculated
        if (dp[left][right] != null) {
            return dp[left][right];
        }

        // First and last characters don't match
        if (s.charAt(left) != s.charAt(right)) {
            dp[left][right] = false;
            return false;
        }

        // Check the inside recursively
        dp[left][right] = isPalindrome(s, left + 1, right - 1, dp);

        return dp[left][right];
    }
}