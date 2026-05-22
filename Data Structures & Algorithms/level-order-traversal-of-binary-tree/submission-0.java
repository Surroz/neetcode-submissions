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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var list = new ArrayList<List<Integer>>();
        if (root != null)
            addChildsAndReturnValue(root, list, 0);

        return list;
    }

    private static void addChildsAndReturnValue(TreeNode node, List<List<Integer>> list, int depth) {
        depth++;
        if (list.size() < depth) {
            var inList = new ArrayList<Integer>();
            inList.add(node.val);
            list.add(inList);
        } else
            list.get(depth-1).add(node.val);

        if (node.left != null) {
            addChildsAndReturnValue(node.left, list, depth);
        }
        if (node.right != null) {
            addChildsAndReturnValue(node.right, list, depth);
        }
    }
}
