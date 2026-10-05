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
    public int findBottomLeftValue(TreeNode root) {
        // Apply BFS Traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            root = queue.poll(); // remove the current node and treat it as current root

            // Add Right Child of that removed node
            if(root.right != null)
                queue.add(root.right);
            // Add Left Child of that removed node
            if(root.left != null)
                queue.add(root.left);
            
        }
        return root.val;
    }
}