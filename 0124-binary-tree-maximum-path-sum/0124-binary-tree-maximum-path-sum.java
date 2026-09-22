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
    int maxSum = Integer.MIN_VALUE;

    public int pathSumOfsubTree(TreeNode root){
        if(root==null) return 0;

        int leftSum = Math.max(0, pathSumOfsubTree(root.left));
        int rightSum = Math.max(0,pathSumOfsubTree(root.right));

        maxSum = Math.max(maxSum,leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum)+root.val;
    }

    public int maxPathSum(TreeNode root) {
        pathSumOfsubTree(root);
        return maxSum;
    }
}