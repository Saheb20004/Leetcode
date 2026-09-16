class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        // Edge Case
        if(n == 1)  return 5;
        if(n == 0)  return 0;

        long even = (n + 1) / 2;  // positions with 5 choices
        long odd = n / 2;         // positions with 4 choices

        long ans = (power(5, even) * power(4, odd)) % MOD;

        return (int) ans;
    }


    private long power(long base, long exp) {
        // Base Case
        if(exp == 0) return 1;
        if(exp == 1) return base % MOD;

        if (exp % 2 == 1) { // n is odd
            return (base * power(base, exp-1)) % MOD;
        }
        // n is even
        return power( (base * base) % MOD, exp/2 );
    }
}