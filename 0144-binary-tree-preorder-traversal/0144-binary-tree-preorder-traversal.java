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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)    return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            // Push Right Child
            if(root.right != null) {
                stack.push(root.right);
            }
            // Push Left Child
            if(root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

}