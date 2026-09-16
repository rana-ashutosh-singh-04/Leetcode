1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    public TreeNode getInOrderSuccessor(TreeNode root) {
19        while (root != null && root.left != null) {
20            root = root.left;
21        }
22        return root;
23    }
24
25    public TreeNode deleteNode(TreeNode root, int key) {
26        if (root == null) {
27            return null;
28        } else if (root.val < key) {
29            root.right = deleteNode(root.right, key);
30        } else if (root.val > key) {
31            root.left = deleteNode(root.left, key);
32        } else {
33            if (root.left == null) {
34                TreeNode temp = root.right;
35                return temp;
36            } else if (root.right == null) {
37                TreeNode temp = root.left;
38                return temp;
39            } else {
40                TreeNode IS = getInOrderSuccessor(root.right);
41                root.val = IS.val;
42                root.right = deleteNode(root.right, IS.val);
43            }
44        }
45        return root;
46    }
47}