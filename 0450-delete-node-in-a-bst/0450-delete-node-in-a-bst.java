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

 // TC  ->  O(H),   H = log₂N

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base Case
        if(root == null)    return null;
        if(root.val == key)     return helper(root);

         // Search for the node and its parent
        TreeNode dummy = root;
        while(root != null){
            
            if(root.val > key){ // Search in left side when root is greater than key
                if(root.left != null && root.left.val == key){
                    // Found key → delete it and reconnect the subtree
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }

            else{ // Search in right side when root is less than key
                if(root.right != null && root.right.val == key){
                    // Found key → delete it and reconnect the subtree
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }


    private TreeNode helper(TreeNode root){
        // No left child → replace node with its right subtree
        if(root.left == null){ 
            return root.right;
        }
        // No right child → replace node with its left subtree
        else if(root.right == null){
            return root.left;
        }

        // Node has two children
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left); // Find the rightmost node of LST
        lastRight.right = rightChild; // Attach the original RST to rightmost node of  LST
        return root.left;
    }


    private TreeNode findLastRight(TreeNode root){
        if(root.right == null){ // Rightmost node found
            return root;
        }
        return findLastRight(root.right); // Recursive checking to go the deepest right
    }
}