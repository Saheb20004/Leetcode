// Solve using DP Tabulatin
//  TC -> O(n * m),     SC -> O(n * m)

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // dp[i][j] = number of distinct subsequences of
        // s[0...i-1] that can form t[0...j-1]
        int[][] dp = new int[n + 1][m + 1];
        // Empty t can be formed from any prefix of s
        // by deleting all characters.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i-1) == t.charAt(j-1)) {
                    // Two choices:
                    // 1. Take s[i-1]
                    // 2. Don't take s[i-1]
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];

                } 
                else {
                    // Characters don't match,
                    // so skip s[i-1]
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}