// Optimal Approach
// TC -> O(9 * 10 * 5 + 10*n)   10*n -> for frequency counting
// SC -> O(1)

class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int num = 0;
        int l = 0;
        int count = 0;

        // Build frequency map Array
        int map[] = new int[10];
        for(int i=0;i <= 9;i++){
            for(int j=0;j<n;j++){
                if(digits[j] == i){
                    map[i] ++;
                }
            }
        }

        // Hundreds digit
        for(int i = 1; i <= 9; i++){
            if(map[i] == 0){
                continue;
            }
            map[i] --;
            // Tens digit
            for(int j = 0; j <= 9; j++){
                if(map[j] == 0){
                    continue;
                }
                map[j] --;
                // Units digit must be even
                for(int k = 0; k <= 8; k += 2){
                    if(map[k] == 0){
                        continue;
                    }
                    map[k] --;
                    
                    num = (i * 100) + (j * 10) + k;
                    
                    count ++;

                    map[k] ++;
                }
                map[j] ++;
            }
            map[i] ++;
        }
        return count;
    }
}