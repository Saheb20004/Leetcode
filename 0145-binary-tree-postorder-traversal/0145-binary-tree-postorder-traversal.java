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
   
    public List<Integer> postorderTraversal(TreeNode root)  {
        List<Integer> list = new ArrayList<>();

        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        // Base Case
        if (root == null) {
            return;
        }
        // Left
        postorder(root.left, list);
        // Right
        postorder(root.right, list);
        // Root
        list.add(root.val);
    }
}