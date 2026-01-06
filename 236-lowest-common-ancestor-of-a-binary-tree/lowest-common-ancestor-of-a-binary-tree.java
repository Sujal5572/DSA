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
        // tc O(n)as we are traversing each node once 
        // sc O(h)recursion stack h is the height of the tree
        if(root == null || root == p || root ==q)// base condtion 
        return root;// if we encounter any one p or q we simple return root 
        TreeNode left= lowestCommonAncestor(root.left, p,q); // left 
        TreeNode right = lowestCommonAncestor(root.right,p,q);//right
      
      if(left == null)return right; //in case of p=6 & q=4 we encounter that left of 2 is null so we return right as we get root = q 
      else if(right == null)return left;
      else{ // If p and q are found in different subtrees of a node, that node is the LCA.
        return root; // like p and q both are not null then we are going return root 3 for p=5 , q=1;
      }
      // if one is an ancestor of other node then ancestor itself is lca


        
    }
}