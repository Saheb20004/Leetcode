class Solution {
    static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {

        // end[c] = number of distinct subsequences
        // whose last character is c
        long[] end = new long[26];

        for (char c : s.toCharArray()) {

            int ch = c - 'a';

            /*
             * Every existing subsequence can be extended
             * by the current character.
             *
             * Also, the current character itself forms
             * a new subsequence.
             *
             * We replace end[ch] because all subsequences
             * ending with this character become represented
             * by the current occurrence.
             */
            long total = 1;

            for (int i = 0; i < 26; i++) {
                total += end[i];
            }

            end[ch] = total % MOD;
        }

        long answer = 0;

        for (int i = 0; i < 26; i++) {
            answer += end[i];
            answer %= MOD;
        }

        return (int) answer;
    }
}