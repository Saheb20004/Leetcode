class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> triangleRow = new ArrayList<>();
        long val=1;
        triangleRow.add((int)val);
    // My approach is for 1-indexed Rows so here I have to do rowIndex + 1
        for(int col=1; col < rowIndex+1 ; col ++){
            val = val * (rowIndex+1 -col);
            val = val / col;
            triangleRow.add((int)val);
        }
        return triangleRow;
    }
}