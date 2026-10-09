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
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return build(preorder, Long.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, long upperBound) {
        // All elements have been processed or  This value belongs to another subtree
        if (i == preorder.length || preorder[i] > upperBound) {
            return null;
        }

        // Create the current root
        TreeNode root = new TreeNode(preorder[i]);
        i++;

        // Construct left subtree
        root.left = build(preorder, root.val);
        // Construct right subtree
        root.right = build(preorder, upperBound);

        return root;
    }
}