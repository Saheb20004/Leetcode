
class Solution {

    // Stores the middle character when the length is odd.
    // '\0' means there is no middle character.
    char midChar = '\0';

    // Number of characters required in the left half.
    int halfLen;

    // Stores the final answer.
    String result = "";

    /*
     * Backtracking function
     *
     * curr    -> currently constructed LEFT HALF of palindrome
     * count   -> remaining frequency of each character
     * target  -> given target string
     * i       -> current position we are filling
     * greater -> whether the left half is already greater than target's prefix
     */
    boolean solve(StringBuilder curr, int count[], String target, int i, boolean greater) {
        /*
         * Once we have constructed the complete left half,
         * we can construct the complete palindrome.
         */
        if (curr.length() == halfLen) {
            // Left half
            String leftHalf = curr.toString();
            // Right half = reverse(left half)
            String rightHalf = new StringBuilder(leftHalf).reverse().toString();
            // Complete palindrome
            String candidate = leftHalf;

            // Add middle character only for odd length
            if (midChar != '\0') {
                candidate += midChar;
            }

            candidate += rightHalf;
            
            // We need a palindrome STRICTLY GREATER than target.
            if (candidate.compareTo(target) > 0) {
                result = candidate;
                return true;
            }

            return false;
        }

        /*
         * Try characters from 'a' to 'z'.
         *
         * Since we try in increasing order, the first valid
         * palindrome we find will be lexicographically smallest.
         */
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // No character of this type is available.
            if (count[ch - 'a'] == 0) {
                continue;
            }

            /*
             * If the palindrome is not greater than target yet,
             * the current character cannot be smaller than target[i].
             *
             * Example:
             *
             * target[i] = 'd'
             *
             * Choosing 'a', 'b', or 'c' would make our palindrome
             * smaller than target, so skip them.
             */
            if (!greater && ch < target.charAt(i)) {
                continue;
            }

            // ---------------- DO ----------------

            // Choose this character.
            curr.append(ch);
            // Use one occurrence.
            count[ch - 'a']--;
            /*
             * After choosing ch, determine whether our prefix
             * has become strictly greater than target's prefix.
             *
             * Once greater becomes true, it stays true forever.
             */
            boolean isGreater = greater || ch > target.charAt(i);

            // ---------------- EXPLORE ----------------

            /*
             * Recursively fill the next position.
             *
             * If a valid answer is found, immediately return true.
             * This is called early termination.
             */
            if (solve(curr, count, target, i + 1, isGreater)) {
                return true;
            }

            // ---------------- UNDO ----------------

            // Remove the character we selected.
            curr.deleteCharAt(curr.length() - 1);

            // Restore its frequency.
            count[ch - 'a']++;
        }

        // No valid palindrome can be constructed from this state.
        return false;
    }


    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Frequency of each lowercase English character.
        int[] count = new int[26];

        // Count frequency of every character in s.
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        /*
         * A palindrome can have at most ONE character
         * with an odd frequency.
         *
         * Example:
         *
         * aabbcc -> possible
         * aabbc  -> possible (c goes in the middle)
         * aabbcd -> impossible (c and d are both odd)
         */
        int oddCount = 0;

        for (int c = 0; c < 26; c++) {

            if (count[c] % 2 == 1) {
                oddCount++;

                // This character will occupy the middle.
                midChar = (char) ('a' + c);
            }
        }

        // More than one odd-frequency character => no palindrome possible.
        if (oddCount > 1) {
            return "";
        }

        /*
         * Only half of every character's frequency
         * is required to construct the left half.
         *
         * Example:
         *
         * s = "aabbcc"
         *
         * frequencies:
         * a = 2, b = 2, c = 2
         *
         * left half needs:
         * a = 1, b = 1, c = 1
         */
        for (int c = 0; c < 26; c++) {
            count[c] /= 2;
        }

        // Length of the left half.
        halfLen = n / 2;

        // Start constructing the left half.
        StringBuilder curr = new StringBuilder();

        /*
         * greater = false initially because we have not
         * made our palindrome greater than target yet.
         */
        solve(curr, count, target, 0, false);

        return result;
    }
}