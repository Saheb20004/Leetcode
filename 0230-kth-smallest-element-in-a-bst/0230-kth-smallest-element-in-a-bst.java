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
    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr = root;
        while (curr != null) {
            // Case 1: No left subtree, Visit current node and move to the right
            if (curr.left == null) {

                k--;
                if (k == 0) { // kth smallest found
                    return curr.val;
                }

                curr = curr.right;
            }

            // Case 2: Left subtree exists
            else {
                // Find the inorder predecessor of curr = rightmost node in curr's left ST
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create temporary thread
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                // Thread already exists → visit curr
                else {
                    prev.right = null;

                    k--;
                    if (k == 0) {
                        return curr.val;
                    }

                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}