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

        long ans = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
                exp --;
            }

            base = (base * base) % MOD;
            exp = exp / 2;
        }

        return ans;
    }
}