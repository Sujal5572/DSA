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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // tc will be O(n) hashmap lookups takes O(1);
        // sc will be O(n) recursion stack and HashMap
        Map<Integer , Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        } 
        TreeNode root = build(preorder , 0, preorder.length-1 , inorder , 0, inorder.length -1 ,map);
        return root;
        
    }
    public TreeNode build(int pre[],int preS ,int preE, int in[] , int inS , int inE ,Map<Integer , Integer> map){
        if(preS > preE || inS > inE)return null;
        TreeNode root = new TreeNode(pre[preS]);
        int inRoot = map.get(root.val); // index at which root is there in inorder;
        int numsLeft = inRoot - inS ; //total number node that will be in left part;[inS , inRoot];
        root.left = build(pre , preS + 1 , preS + numsLeft , in , inS , inRoot-1,map);
        // pre will start from next index and move till numsLeft and in will be from inS and till inRoot -1
        root.right = build(pre , preS + numsLeft + 1 , preE , in , inRoot +1 , inE , map);
        // for right pre will be from that index where left end +1 and in will from inRoot +1 till end
        return root;
    }
}