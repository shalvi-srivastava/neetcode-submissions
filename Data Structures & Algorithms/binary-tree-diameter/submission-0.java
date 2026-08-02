class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        diameter = Math.max(diameter, lh + rh);
        return Math.max(lh, rh) + 1;
    }
}