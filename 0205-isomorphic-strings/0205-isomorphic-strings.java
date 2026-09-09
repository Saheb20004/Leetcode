class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Edge Case
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            int firstS = s.indexOf(c1);
            int firstT = t.indexOf(c2);

            if (firstS != firstT) {
                return false;
            }
        }

        return true;
    }
}