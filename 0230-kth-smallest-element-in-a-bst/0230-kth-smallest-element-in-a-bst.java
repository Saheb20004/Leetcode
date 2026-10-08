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
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // 1. Go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. Process the node
            curr = stack.pop();
            list.add(curr.val);

            // 3. Move to the right subtree
            curr = curr.right;
        }
    }

}