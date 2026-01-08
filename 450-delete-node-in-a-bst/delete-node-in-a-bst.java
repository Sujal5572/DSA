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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        return null;
        if(root.val == key)
        return help(root);
        TreeNode dummy = root; // we need return root so it should not be lost during deletion
        while(root != null){
            if(root.val > key){ // we can find our key in left part
                if(root.left!= null && root.left.val == key){
                    root.left = help(root.left); // if we encounter root.left val is key then root.left should point to root.left.left
                    break;
                }
                root = root.left; // else we are traversing in left
            }
            else{
                if(root.right!= null && root.right.val ==key){
                    root.right = help(root.right); 
                    break;
                }
                root = root.right;
            }
        }
        return dummy;
        
    }
    private TreeNode help(TreeNode root){
        if(root.left == null) // if no ele at left then root.left -> root.left.right (see line 26)
        return root.right;
        if(root.right == null)
        return root.left; // similarly
        TreeNode Rightchild = root.right; // we are storing the rightchild 
        TreeNode lastRight = FindlastRightInLeft(root.left); // we are finding the right most node in left child 
        lastRight.right = Rightchild; // that last.right -> right child
        return root.left; 
    }
    TreeNode FindlastRightInLeft(TreeNode root){
        if(root.right == null)
        return root;
       return FindlastRightInLeft(root.right);

    }
}