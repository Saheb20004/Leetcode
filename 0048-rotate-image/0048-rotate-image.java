class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose
        for(int i = 0; i < n-1; i++){

            for(int j = i + 1; j < n; j++){
                // Swap
                swap(matrix, i, j);
            }
        }

        // Step 2: Reverse every row
        for(int i = 0; i < n; i++){
            reverse(matrix, i, 0, n-1);
        }
    }

    private void swap(int matrix[][], int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void reverse(int matrix[][],int row, int left, int right){
        int n=matrix.length;

        while(left < right){

            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }

}