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
import java.util.*;

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        int[] inorder = preorder.clone();
        Arrays.sort(inorder);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] preIndex = {0};

        return build(preorder, 0, inorder.length - 1, preIndex, map);
    }

    private TreeNode build(int[] preorder, int left, int right,
                           int[] preIndex, Map<Integer, Integer> map) {

        if (left > right) {
            return null;
        }

        // First unused preorder element is the root
        int rootVal = preorder[preIndex[0]++];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int mid = map.get(rootVal);

        // Construct left and right subtrees
        root.left = build(preorder, left, mid - 1, preIndex, map);
        root.right = build(preorder, mid + 1, right, preIndex, map);

        return root;
    }
}