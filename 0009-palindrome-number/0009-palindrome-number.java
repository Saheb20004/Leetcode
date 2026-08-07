// A palindrome is a number (or word) that reads the same forwards and backwards

class Solution {
    public boolean isPalindrome(int x) {
        int lastDigit=0;
        int reverse=0;
        int original=x;
        while(x > 0){
            lastDigit=x%10;
            x=x/10;
            reverse = reverse*10 + lastDigit;
        }
        if(original == reverse) return true;
        return false;
    }
}