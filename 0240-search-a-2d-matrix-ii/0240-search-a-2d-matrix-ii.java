
// Optimal using Binary Search Algo

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // No. of Rows
        int n = matrix[0].length; // No. of Columns
        
        int row = 0;
        int col = n-1;

        while( row < m  &&  col >= 0){

            if( matrix[row][col] == target ){
                return true;
            }
            else if( matrix[row][col] > target ){
                col --;
            }
            else{
                row ++;
            }
        }
        return false;
    }
}