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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return rootForValues(root, min, max);
        
    }
    public static TreeNode rootForValues(TreeNode node, int min, int max) {
        if (node.val >= min && node.val <= max) {
            return node;
        }
        TreeNode res;
        if (node.val > min)
            res = rootForValues(node.left, min, max);
        else
            res = rootForValues(node.right, min, max);

        return res;
    }
}
