// Solve using DP Memoization
//  TC -> O(n * m),     SC -> O(n + m) + O(n * m)

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // dp[i][j] = answer for s[0...i] and t[0...j]
        int[][] dp = new int[n][m];
        // -1 means this state has not been calculated yet
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helperFn(n-1, m-1, s, t, dp);
    }

    private int helperFn(int i, int j, String s, String t, int[][] dp) {
        //      Base Case
        // t is completely matched
        if (j < 0) return 1;
        // s is exhausted but t is still remaining
        if (i < 0) return 0;
        // Already calculated this state
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            // Take s[i] and match it with t[j]
            int take = helperFn(i-1, j-1, s, t, dp);
            // Don't take s[i]
            int notTake = helperFn(i-1, j, s, t, dp);

            dp[i][j] = take + notTake;
        } 
        else {
            // Characters don't match, so skip s[i]
            dp[i][j] = helperFn(i-1, j, s, t, dp);
        }

        return dp[i][j];
    }
}