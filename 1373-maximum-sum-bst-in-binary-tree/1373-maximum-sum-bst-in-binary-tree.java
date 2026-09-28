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
    int maxSum = 0;

    class Info{
        int max;
        int min;
        int sum;

        Info(){
            this.max = 0;
            this.min = 0;
            this.sum = 0;
        }

        Info(int max, int min, int sum ){
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        maxSumOfsubBST(root);
        return maxSum;
    }

    public Info maxSumOfsubBST(TreeNode root){
        if(root==null){
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,0);
        }
        Info left = maxSumOfsubBST(root.left);
        Info right = maxSumOfsubBST(root.right);

        if(left.max>=root.val || right.min<=root.val){

            int currMaxSum = Math.max(left.sum,right.sum);
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE,Math.max(left.sum,right.sum));
        }else{
            int currMaxSum = left.sum+right.sum+root.val;
                maxSum = Math.max(maxSum,currMaxSum);
                return new Info(Math.max(right.max,root.val),Math.min(left.min,root.val),currMaxSum);
        }

    }
}