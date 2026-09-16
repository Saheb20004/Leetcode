class Solution {

    public int myAtoi(String s) {
        return skipSpaces(s, 0);
    }

    // Step 1: Skip leading spaces
    private int skipSpaces(String s, int i) {
        if (i < s.length() && s.charAt(i) == ' ') {
            return skipSpaces(s, i + 1);
        }

        return handleSign(s, i);
    }

    // Step 2: Handle sign
    private int handleSign(String s, int i) {

        if (i >= s.length()) {
            return 0;
        }

        if (s.charAt(i) == '-') {
            return processDigits(s, i + 1, 0, -1);
        }

        if (s.charAt(i) == '+') {
            return processDigits(s, i + 1, 0, 1);
        }

        return processDigits(s, i, 0, 1);
    }

    // Step 3: Process digits
    private int processDigits(String s, int i, long num, int sign) {

        // Stop at non-digit
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int) (sign * num);
        }

        int digit = s.charAt(i) - '0';

        num = num * 10 + digit;

        long value = sign * num;

        // Overflow
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return processDigits(s, i + 1, num, sign);
    }
}