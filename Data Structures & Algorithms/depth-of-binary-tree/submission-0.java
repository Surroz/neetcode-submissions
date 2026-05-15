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
    public int maxDepth(TreeNode root) {
        return countDepth(root, 0);
    }
    public static int countDepth(TreeNode node, int depth) {
        if (node != null) {
            depth++;
            int leftDepth = countDepth(node.left, depth);
            int rightDepth = countDepth(node.right, depth);
            depth = Math.max(leftDepth, rightDepth);
        }
        return depth;
    }
}
