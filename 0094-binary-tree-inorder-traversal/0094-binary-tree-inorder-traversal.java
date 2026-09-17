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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        // Base Case
        if (root == null) {
            return;
        }
        // Left
        inorder(root.left, list);
        // Root
        list.add(root.val);
        // Right
        inorder(root.right, list);
    }
}