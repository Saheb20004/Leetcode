// Better Approach
// TC -> O(26 * n²),     SC -> O(26)=O(1)

class Solution {

    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        // Generate every substring
        for (int i = 0; i < n; i++) {
            // Frequency array for current substring
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                // Add current character
                int index = s.charAt(j) - 'a';
                freq[index]++;

                // Find maximum and minimum frequency
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {

                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                // Calculate beauty
                ans += maxFreq - minFreq;
            }
        }

        return ans;
    }
}