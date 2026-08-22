class Solution {
    public boolean checkDivisibility(int n) {
        int rem=0;
        int sum=0;
        int prod=1;
        int org=n;
        while(n > 0){
            rem = n % 10;

            sum += rem;
            prod *= rem;

            n = n / 10;
        }
        return org % (sum+prod) == 0 ? true : false;
    }
}