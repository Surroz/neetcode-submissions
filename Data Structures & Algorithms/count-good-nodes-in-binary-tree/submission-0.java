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
    public int goodNodes(TreeNode root) {
        return countNodesRecursive(root, 0, Integer.MIN_VALUE);
    }

    private static int countNodesRecursive(TreeNode node, int count, int max) {
        if (node != null) {
            if (max <= node.val) {
                count++;
                max = node.val;
            }
            count = countNodesRecursive(node.left, count, max);
            count = countNodesRecursive(node.right, count, max);
        }
        return count;
    }
}
