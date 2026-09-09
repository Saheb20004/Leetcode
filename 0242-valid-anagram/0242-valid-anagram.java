// Better Approach Using HashMap

class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge Case
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Increment count of characters
        }

        // Remove characters using t
        for (char ch : t.toCharArray()) {

            if (!map.containsKey(ch)) { // If key does not exist
                return false;
            }

            map.put(ch, map.get(ch) - 1); // Decrement count of characters

            if (map.get(ch) < 0) { // If Charater count becomes negative
                return false;
            }
        }

        return true;
    }
}