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
    public List<String> binaryTreePaths(TreeNode root) {
        //your code goes here
        List<String> result = new ArrayList<>();

        getPath(root, "", result);

        return result;
    }

    private void getPath(TreeNode node, String path, List<String> result){
        
        // Base Case
        if(node == null)    return ;

        path += node.val;

        if(isLeaf(node)){
            result.add(path);
            return;
        }

        // Add arrow before going to child
        path += "->";

        getPath(node.left, path, result);
        getPath(node.right, path, result);
    }


    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

}