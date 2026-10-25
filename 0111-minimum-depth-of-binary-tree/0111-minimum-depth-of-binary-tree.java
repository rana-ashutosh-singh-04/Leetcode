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
     public int minDepthChild(TreeNode par, int count){

        TreeNode left = par.left;
        TreeNode right = par.right;

        if(left!=null && right !=null){
            int leftCount = minDepthChild(par.left,count);
            int rightCount = minDepthChild(par.right,count);

            return(Math.min(leftCount,rightCount)+1);
        }else if(left==null && right!=null){
           return (minDepthChild(par.right,count)+1);
        }else if(right==null && left!=null){
            return(minDepthChild(par.left,count)+1);
        }else{
            return +1;
        }
        
        
    }
    public int minDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        return minDepthChild(root,0);
    }
}