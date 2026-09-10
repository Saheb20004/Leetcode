class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();

        // Edge case
        if (n <= 1) {
            return s;
        }

        // dp[i][j] = true if s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Length of substring
        for (int len = 2; len <= n; len++) {
            // Starting index
            for (int i = 0; i <= n - len; i++) {
                // Ending index
                int j = i + len - 1;
                // Check first and last characters
                if (s.charAt(i) == s.charAt(j)) {
                    // Length 2: "aa"
                    // Length > 2: check inside substring
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (len > maxLen) {
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}