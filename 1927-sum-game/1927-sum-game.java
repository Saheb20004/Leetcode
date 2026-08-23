        // Approach

// 1. Divide string into left/right halves
// 2. Calculate known digit sums
// 3. Count '?' on each side
// 4. Odd total '?' → Alice wins
// 5. Otherwise compare:

//    2 × knownSum + 9 × questionMarks

// 6. Equal → Bob wins
// 7. Unequal → Alice wins

class Solution {
    public boolean sumGame(String num) {
        int n=num.length(); // Length of the String

        int leftKnownSum=0, rightKnownSum=0;
        int leftQMarkCount=0, rightQMarkCount=0;

        for(int i=0;i<n;i++){

            if(num.charAt(i) == '?'){
                if(i < n/2){
                    leftQMarkCount ++;
                }
                else{
                    rightQMarkCount ++;
                }
            }

            else{
                if(i < n/2){
                    leftKnownSum += num.charAt(i) - '0';
                }
                else{
                    rightKnownSum += num.charAt(i) - '0';
                }
            }
        }

        int totalQMarks = leftQMarkCount + rightQMarkCount;
        if( totalQMarks % 2 == 1 ){
            return true; // Alice always wins is If totalQMarks is odd
        }

        int LEFT = 2*leftKnownSum  +  9*leftQMarkCount;
        int RIGHT = 2*rightKnownSum  +  9 * rightQMarkCount;
        // Bob can make the sums equal
        if(LEFT == RIGHT) return false; // Bob wins

        // Alice can force the sums to be different
        return true;
    }
}