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
    int count =0;
    int kth;
    public void inOrderTraversal(TreeNode root, int k){
        if(root==null) return ;

        inOrderTraversal(root.left,k);
        count++;
        if(count==k){
            kth = root.val;
            return;
        } 
        inOrderTraversal(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        inOrderTraversal(root,k);
        return kth;

    }
}