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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
        return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder , 0 , inorder.length -1 , postorder , 0 , postorder.length -1 , map);
        
    }
    public TreeNode build(int In[] , int InS , int InE , int Po[], int PoS , int PoE , Map<Integer, Integer> map){
        if(InS >InE || PoS > PoE)return null;
        TreeNode root =new TreeNode(Po[PoE]);
        int InRoot = map.get(Po[PoE]);
        int numsLeft = InRoot - InS;
        root.left=build(In , InS , InRoot -1 , Po , PoS ,PoS + numsLeft - 1,map);
        root.right = build(In , InRoot +1 , InE , Po , PoS + numsLeft , PoE-1 ,map);
        return root;
    }
}