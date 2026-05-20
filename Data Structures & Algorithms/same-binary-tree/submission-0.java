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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean same = true;
        if(p == null && q == null) return same;
        
        if((p == null && q != null)
                || (p != null && q == null)
        )
            return false;

        return compareNodes(p,q, same);
    }

    public static boolean compareNodes(TreeNode p, TreeNode q, boolean res) {
        if (!res) return res;
        
        if(
                ((p.left == null && q.left != null)
                    || (p.left != null && q.left == null))
                ||
                ((p.right == null && q.right != null)
                    || (p.right != null && q.right == null))
        )
            return false;

        res = p.val == q.val;

        if(p.left != null && q.left != null) {
            res = compareNodes(p.left, q.left, res);
        }

        if(p.right != null && q.right != null) {
            res = compareNodes(p.right, q.right, res);
        }
        return res;
    }
}