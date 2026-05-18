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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return false;
        return help(root.left , root.right);
    }
    public boolean help(TreeNode L , TreeNode R){
        if(L == null && R == null)return true;
        if(L!=null && R!=null && L.val == R.val){
            return help(L.left,R.right) && help(L.right,R.left);
        }
        return false;
    }
}