// Better Approach using hashing

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
            // code here
        int ans[] = new int[2];
            
        int n = grid.length; // n x n grid
            
        int hash[] = new int[n*n + 1]; // Extra space O(n²)
        
        // Mark the frequency in the hash array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hash[grid[i][j]]++;
            }
        }
        
        int repeating = -1;
        int missing = -1;
        // Finding in the Hash Array
        for(int i=1;i <= n*n;i++){
            if(hash[i] == 2)    repeating = i;
            else if(hash[i] == 0)   missing = i;
        }
            
        ans[0]=repeating;
        ans[1]=missing;

        return ans;
    }
}