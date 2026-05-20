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
    
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findHead(root, subRoot, false);
    }

    public static boolean findHead(TreeNode node, TreeNode subRoot, boolean res) {
        if (node == null || subRoot == null)
            return res;
        if (node.val == subRoot.val) {
            res = compareTrees(node.left, subRoot.left, res);
            if (res)
                res = compareTrees(node.right, subRoot.right, res);
            if (res)
                return res;
        }
        res = findHead(node.left, subRoot, res);
        if (!res)
            res = findHead(node.right, subRoot, res);

        return res;
    }

    public static boolean compareTrees(TreeNode node, TreeNode subNode, boolean res) {
        if (node == null || subNode == null){
            return node == null && subNode == null;
        }
        res = node.val == subNode.val;
        if (res) {
            res = compareTrees(node.left, subNode.left, res);
            if (res)
                res = compareTrees(node.right, subNode.right, res);
        }
        return res;
    }
}
