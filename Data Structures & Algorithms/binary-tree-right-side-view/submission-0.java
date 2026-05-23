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
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        addRightVal(root, list, 0);
        return list;
    }

    private static void addRightVal(TreeNode node, List<Integer> list, int depth) {
        if (node != null) {
            if (list.size() < ++depth) {
                list.add(node.val);
            }
            addRightVal(node.right, list, depth);
            addRightVal(node.left, list, depth);
        }
    }
}
