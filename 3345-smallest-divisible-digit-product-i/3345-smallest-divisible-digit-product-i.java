class Solution {
    public int smallestNumber(int n, int t) {
        while(prodOfDigits(n)%t != 0){
            n++;
        }
        return n;
    }

    private int prodOfDigits(int n){
        int digit=0;
        int product=1;
        while(n>0){
            digit=n%10;
            product *= digit;
            n=n/10;
        }
        return product;
    }
}
