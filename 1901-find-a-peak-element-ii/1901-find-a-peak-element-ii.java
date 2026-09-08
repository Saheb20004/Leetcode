class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int midCol = low + (high-low)/2;
            int rowIdx = findMaxValRowIdx(mat, m, n, midCol);

            int left = midCol-1 >= 0 ? mat[rowIdx] [midCol-1] : -1; 
            int right = midCol+1 < n ? mat[rowIdx] [midCol+1] : -1; 

            if(mat[rowIdx] [midCol] > left && mat[rowIdx] [midCol] > right){
                return new int[] {rowIdx, midCol};
            }
            else if(mat[rowIdx] [midCol] < left){
                high = midCol-1;
            }
            else{
                low = midCol+1;
            }
        }
        return new int[] {-1, -1};
    }

    // Fn to calculate the rowIdx for the maxVal of the mid Column
    private int findMaxValRowIdx(int mat[][], int m, int n, int col){
        int maxVal = -1;
        int maxValRowIdx = -1;

        for(int i=0;i<m;i++){
            if(mat[i][col] > maxVal){
                maxVal = mat[i][col];
                maxValRowIdx = i;
            }
        }
        return maxValRowIdx;
    }

}