// Memoization DP


class Solution {
    static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int n = s.length();

        // dp[i] = number of distinct non-empty subsequences
        // that can be formed using s[0...i]
        int[] dp = new int[n];

        // -1 means this state has not been calculated yet
        Arrays.fill(dp, -1);

        return helperFn(n - 1, s, dp);
    }

    private int helperFn(int i, String s, int[] dp) {

        // Base Case
        // No characters -> no non-empty subsequence
        if (i < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        /*
         * For every subsequence formed using s[0...i-1],
         * we have two choices:
         *
         * 1. Don't take s[i]
         * 2. Take s[i]
         *
         * Taking s[i] creates new subsequences by appending
         * s[i] to every previous subsequence, plus s[i] itself.
         */
        int notTake = helperFn(i - 1, s, dp);

        int take = helperFn(i - 1, s, dp) + 1;

        dp[i] = (int)((notTake + (long) take) % MOD);

        /*
         * If the same character appeared before, some of the
         * subsequences counted by 'take' are duplicates.
         *
         * Find the previous occurrence of s[i].
         */
        int prev = -1;

        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                prev = j;
                break;
            }
        }

        /*
         * Remove the duplicate subsequences that were already
         * created when the previous occurrence was processed.
         */
        if (prev != -1) {
            dp[i] = (int)((dp[i] - (long) helperFn(prev - 1, s, dp) - 1 + MOD) % MOD);
        }

        return dp[i];
    }
}