class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<> ();
        for(int row=1; row <= numRows; row++){
            triangle.add(generateRow(row));
        }
        return triangle;
    }

    private List<Integer> generateRow(int row){
        List<Integer> triangleRow = new ArrayList<>();
        int val=1;
        triangleRow.add(val);

        for(int col=1; col < row; col ++){
            val = val * (row-col);
            val = val / col;
            triangleRow.add(val);
        }
        return triangleRow;
    }
}