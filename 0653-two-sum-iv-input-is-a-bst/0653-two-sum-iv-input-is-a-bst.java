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
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator forward = new BSTIterator(root, true);
        BSTIterator backward = new BSTIterator(root, false);

        int left = forward.next();
        int right = backward.next();

        while (left < right) {
            int sum = left + right;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                if (!forward.hasNext()) {
                    return false;
                }
                left = forward.next();
            } else {
                if (!backward.hasNext()) {
                    return false;
                }
                right = backward.next();
            }
        }

        return false;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean forward;

    public BSTIterator(TreeNode root, boolean forward) {
        this.forward = forward;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();

        if (forward) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }

        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);

            if (forward) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}