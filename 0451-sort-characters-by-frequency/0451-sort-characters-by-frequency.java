class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[123];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        StringBuilder ans = new StringBuilder();

        for (int count = 0; count < s.length(); count++) {

            int maxFreq = 0;
            int maxChar = -1;

            // Find character having maximum frequency
            for (int i = 0; i < 123; i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = i;
                }
            }

            if (maxChar == -1) {
                break;
            }

            // Add character maxFreq times
            for (int i = 0; i < maxFreq; i++) {
                ans.append((char) maxChar);
            }

            // Mark character as processed
            freq[maxChar] = 0;
        }

        return ans.toString();
    }
}