class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == ')') {
                // Reverse characters inside ()
                StringBuilder sb = new StringBuilder();

                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                // Remove '('
                st.pop();

                // Put reversed characters back
                for (char c : sb.toString().toCharArray()) {
                    st.push(c);
                }

            } 

            else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}