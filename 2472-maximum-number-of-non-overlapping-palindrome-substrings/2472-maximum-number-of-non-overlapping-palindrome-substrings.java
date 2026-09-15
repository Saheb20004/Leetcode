class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        // Edge Case
        if (k == 1)
            return n;

        int count = 0;

        for (int i = 0; i <= n-k; i++) {
            // Check palindrome of length k
            if (isPalindrome(s, i, i + k-1)) {
                count ++;
                i += k-1;
            } 
            // Check palindrome of length k + 1
            else if (i < n-k && isPalindrome(s, i, i + k)) {
                count ++;
                i += k;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        for (; left < right;  left ++,right --)
            if (s.charAt(left) != s.charAt(right))
                return false;
        return true;
    }
}