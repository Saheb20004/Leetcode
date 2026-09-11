// Brute Force Approach
// TC -> O(n³ + k * log k) ,    k -> no. of unique 3-digit even elements
// SC -> O(k)

class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int num = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }
                    num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if(num >= 100 && num % 2 == 0){ // Check for Even && no leading zeros
                        set.add(num);
                    }
                }
            }
        }
        return set.size();
    }
}