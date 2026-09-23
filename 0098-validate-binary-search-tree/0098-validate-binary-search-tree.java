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

    long max = Long.MAX_VALUE;
    long min =  Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root, long min, long max){

        if(root==null)return true;

        if(root.val<=min || root.val >=max){
            return false;
        }

        boolean isLeftValid = isValidBST(root.left,min,root.val);
        boolean isRightValid = isValidBST(root.right,root.val,max);

        return isLeftValid && isRightValid;
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,min, max);
    }
}