class Solution {

    public double myPow(double x, int n) {
        long pow = n;

        // Handle negative exponent
        if (pow < 0)
            pow = -pow;

        double ans = power(x, pow);

        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
    }

    private double power(double x, long n) {
        // Base case
        if(n == 0)  return 1.0;
        if(n == 1)  return x;

        // If exponent is odd
        if (n % 2 == 1) {
            return x * power(x, n-1);
        }

        // If exponent is even
        return power(x * x, n / 2);
    }
}