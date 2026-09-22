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
    int maxDia ;

    public int heightOfsubTree(TreeNode root){
        if(root==null) return 0;

        int leftHeight = heightOfsubTree(root.left);
        int rightHeight = heightOfsubTree(root.right);

        maxDia = Math.max(maxDia,leftHeight+rightHeight+1);

        return Math.max(leftHeight,rightHeight)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ht =  heightOfsubTree(root);
        return maxDia-1;
    }
}