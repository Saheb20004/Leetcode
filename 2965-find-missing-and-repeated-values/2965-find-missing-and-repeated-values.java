// Optimal Approach using Simple Math 

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
            // code here
        int ans[] = new int[2];
            
        int n = grid.length; // n x n grid
        long total = (long)n * n;
            
        long Sn = ( total * (total+1)) / 2; // Sum of first n² Natural number
        long Sn2 = ( total * (total+1) * (2*total + 1)) / 6; // Sum of the square of first n² Natural number
        
        long S = 0;
        long S2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                S += grid[i][j];
                S2 += (long)grid[i][j]* grid[i][j];
            }
        }
        
        long val1 = S - Sn;// val1    ->  x-y
        long val2 = S2 - Sn2;// val2    ->  x*x -y*y
        val2 = val2/val1;// val2    ->  x+y
        
        long x = (val1+val2)/2; // x    ->  repeating
        long y = (val2-val1)/2; // y    ->  missing
            
        ans[0]=(int)x;
        ans[1]=(int)y;

        return ans;
    }
}