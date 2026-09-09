class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (counter > 0) {
                    ans.append(ch);
                }
                counter ++;
            }
            
            else {
                counter --;

                if (counter > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}