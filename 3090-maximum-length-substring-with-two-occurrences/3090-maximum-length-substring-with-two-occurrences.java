class Solution {
    public int maximumLengthSubstring(String s) {
        // 🔢 Frequency of each lowercase character
        int[] freq = new int[26];
        int left=0;
        int ans = 0;

        // ➡️ Expand the sliding window
        for (int right = 0; right < s.length(); right++) {
            // Add current character
            freq[s.charAt(right) - 'a']++;

            // 🚨 If current character appears more than twice,
            // shrink the window from the left
            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            // 🏆 Update maximum valid window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}