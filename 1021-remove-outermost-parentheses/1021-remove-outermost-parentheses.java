class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening parenthesis
            if (ch == '(') {

                // If stack is empty, this is the outermost '('
                if (!st.isEmpty()) {
                    ans.append(ch);
                }

                st.push(ch);
            }

            // Closing parenthesis
            else {

                st.pop();

                // If stack is not empty after popping,
                // this ')' is NOT the outermost ')'
                if (!st.isEmpty()) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}