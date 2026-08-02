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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        nodes.addAll(postorderTraversal(root.left));
        nodes.addAll(postorderTraversal(root.right));
        nodes.add(root.val);
        return nodes;
    }
}