class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            }

            else if (ch == '*') {
                starStack.push(i);
            }

            else { // ch == ')'

                if (!openStack.isEmpty()) {
                    openStack.pop();
                }
                else if (!starStack.isEmpty()) {
                    starStack.pop();
                }
                else {
                    return false;
                }
            }
        }

        // Match remaining '(' with '*'
        while (!openStack.isEmpty() && !starStack.isEmpty()) {

            int openIndex = openStack.pop();
            int starIndex = starStack.pop();

            // '*' must come after '('
            if (openIndex > starIndex) {
                return false;
            }
        }

        // If '(' are still remaining, they cannot be matched
        return openStack.isEmpty();
    }
}