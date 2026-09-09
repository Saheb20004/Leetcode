// Optimal Approach

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Add frequency of characters from s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Subtract frequency of characters from t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Check if all frequencies are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}