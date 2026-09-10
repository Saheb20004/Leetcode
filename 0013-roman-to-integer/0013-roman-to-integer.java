
class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = value(s.charAt(i));
            //  next =  map.get(s.charAt(i + 1));

            if ( i+1 < s.length() && current < value(s.charAt(i + 1)) ) {
                ans -= current;
            }
            else {
                ans += current;
            }
        }

        return ans;
    }

    private int value(char ch) {

        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000; // M
    }
}