/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// BFS Queue → traverse tree level by level
// TreeMap → maintain columns from left to right
// Nested TreeMap → maintain rows from top to bottom
// PriorityQueue → sort node values when multiple nodes have the same (column, row)


// TreeMap 1 → sorts columns
// TreeMap 2 → sorts rows
// PriorityQueue → sorts values at the same row & column.

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
                = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple tuple = q.poll();

            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            // Create column
            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            // Create row
            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            // Store node value
            map.get(col).get(row).offer(node.val);

            // Left child
            if (node.left != null) {
                q.offer(new Tuple(
                    node.left,
                    row + 1,
                    col - 1
                ));
            }

            // Right child
            if (node.right != null) {
                q.offer(new Tuple(
                    node.right,
                    row + 1,
                    col + 1
                ));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : rows.values()) {

                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            result.add(column);
        }

        return result;
    }
}