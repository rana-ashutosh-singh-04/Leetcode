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

    public boolean dfs(TreeNode rootL, TreeNode rootR){
        if(rootL==null || rootR==null){
            if(rootL==rootR) return true;
            else return false;
        }

        if(rootL.val!=rootR.val){
            return false;
        }else{
            boolean l1 =  dfs(rootL.left,rootR.right);
            boolean l2 = dfs(rootL.right,rootR.left);
            if(l1==true && l2==true){
                return true;
            }else return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;

        return dfs(root.left , root.right);
    }
}