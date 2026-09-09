class Solution {
    public boolean rotateString(String s, String goal) {
        // Edge Case
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}