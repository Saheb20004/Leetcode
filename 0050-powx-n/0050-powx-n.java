class Solution {
    public double myPow(double x, int n) {

        long pow = n;

        if (pow < 0) {
            pow = -pow;
        }

        double ans = 1.0;

        while (pow > 0) {

            if (pow % 2 == 1) {
                ans = ans * x;
                pow--;
            } 
            else {
                x = x * x;
                pow = pow / 2;
            }
        }

        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
    }
}