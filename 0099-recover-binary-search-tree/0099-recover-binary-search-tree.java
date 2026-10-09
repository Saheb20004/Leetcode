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
 
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        inorder(root, values);
        Collections.sort(values);

        int[] index = {0};
        recover(root, values, index);
    }

    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    private void recover(TreeNode root, List<Integer> values, int[] index) {
        if (root == null) {
            return;
        }

        recover(root.left, values, index);
        root.val = values.get(index[0]++);
        recover(root.right, values, index);
    }
}