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
    int idx = 0;

    public int findIdx(int[] inorder,int k){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==k)return i;
        }
        return -1;
    }

    public TreeNode buildBT(int[] preorder, int[] inorder, int si, int ei){

        if(si>ei){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);

        int mid = findIdx(inorder,root.val);
        
        root.left = buildBT(preorder,inorder,si,mid-1);
        root.right = buildBT(preorder,inorder,mid+1,ei);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBT(preorder,inorder, 0, preorder.length-1);
    }
}