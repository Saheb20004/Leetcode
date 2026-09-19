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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    private int findMax(TreeNode root) {
        // Base Case
        if(root == null)    return 0;
        int leftHeight = findMax(root.left);
        int rightHeight = findMax(root.right);

        max = Math.max(max, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}