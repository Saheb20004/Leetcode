// Extreme Brute Force
// TC - O(n*n * n*n)
// SC - O(n*n)
// Brute Force
// TC - O(n*n * n * n)
// SC - O(1)

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
            // code here
            int ans[] = new int[2];
            
            int n = grid.length; // n x n grid
            
            int missing = 0;
            int duplicate = 0;
            // Iterate from 1 to n*n and check
            // if the current number is present
            for (int num = 1; num <= n*n; num++) {
                int count = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(grid[i][j] == num)
                            count ++;
                    }
                }

                // If the current number is not present
                if (count == 0)
                    missing = num;
                    
                else if(count == 2)
                    duplicate = num;
            }
            
            ans[0]=duplicate;
            ans[1]=missing;

        return ans;
    }
}