// Optimal using Binary Search Algo

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // No. of Rows
        int n = matrix[0].length; // No. of Columns
        // Flattern the 2D array into 1D array hypothetically
        int low = 0;
        int high = m * n - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid / n;
            int col = mid % n;

            if( matrix[row][col] == target ){
                return true;
            }
            else if( matrix[row][col] > target ){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}