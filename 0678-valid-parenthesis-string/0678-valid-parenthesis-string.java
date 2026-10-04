class Solution {
    public boolean checkValidString(String s) {
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            open += s.charAt(i) == '(' ? 1 : -1;
            close += s.charAt(i) == ')' ? -1 : 1;

            if (close < 0) return false;

            open = Math.max(open, 0);
        }

        return open == 0;
    }
}