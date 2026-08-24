// Extreme Brute Force
// TC - O(n*n * n*n)
// SC - O(n*n)

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
            // code here
            int ans[] = new int[2];
            
            int n = grid.length; // n x n grid

            int arr[] = new int[n * n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[index] = grid[i][j];
                    index++;
                }
            }
            int missing = 0;
            int duplicate = 0;
            // Iterate from 1 to n and check
            // if the current number is present
            for (int i = 1; i <= n*n; i++) {
                int count = 0;
                for (int j = 0; j < n*n; j++) {
                    if (arr[j] == i) {
                        count ++;
                    }
                }
                // If the current number is not present
                if (count == 0)
                    missing = i;
                    
                else if(count == 2)
                    duplicate = i;
            }
            
            ans[0]=duplicate;
            ans[1]=missing;
        return ans;
    }
}