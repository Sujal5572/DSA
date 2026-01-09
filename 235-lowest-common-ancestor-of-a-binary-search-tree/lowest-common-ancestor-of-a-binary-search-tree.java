/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // tc O(h)as in each recursion we are going either in left or right 
        // sc O(1)
        if(root == null)return null;
        int curr = root.val;
        if(curr>p.val && curr>q.val) // if curr> p and q then it should be in left tree
        return lowestCommonAncestor(root.left, p , q);
        if(curr< p.val && curr < q.val) // else right 
        return lowestCommonAncestor(root.right , p,q); // if it in both then return root as that will be lca
        return root;
        
    }
}