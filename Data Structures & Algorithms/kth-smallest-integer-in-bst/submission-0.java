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
    public int kthSmallest(TreeNode root, int k) {
        return iterateNextNode(root, new Elem(k)).val;
    }
    public static Elem iterateNextNode(TreeNode node, Elem elem) {
        if (node != null) {
            elem = iterateNextNode(node.left, elem);
            elem.count--;
            if (elem.count == 0) {
                elem.val = node.val;
            }
            elem = iterateNextNode(node.right, elem);
        }
        return elem;
    }

    private static class Elem {
        Integer val;
        int count;

        public Elem(int count) {
            this.count = count;
        }
    }
}
