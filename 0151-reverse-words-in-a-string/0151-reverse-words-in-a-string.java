class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // No more words
            if (i < 0) {
                break;
            }

            // Find the end of the word
            int end = i;

            // Move to the beginning of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Add space between words
            if (ans.length() > 0) {
                ans.append(' ');
            }

            // Add the word
            ans.append(s.substring(i + 1, end + 1));
        }

        return ans.toString();
    }
}