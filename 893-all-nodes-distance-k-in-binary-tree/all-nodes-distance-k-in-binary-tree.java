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
    private void buildParent(TreeNode node , TreeNode parent , Map<TreeNode ,TreeNode> parent_map){
        if(node == null)return ;
        parent_map.put(node , parent);
        buildParent(node.left , node , parent_map);
        buildParent(node.right , node , parent_map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // tc will be O(n)as we are traversing level wise and visiting every node once 
        // sc will be O(n) parent map same q and set 
        Map<TreeNode , TreeNode> parent_map = new HashMap<>(); // child to parent mapping as we need to traverse in upward dirn also 
        buildParent(root, null , parent_map); // node , parent , parent_map
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.offer(target);
        vis.add(target);
        int distance =0;
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k)
            break;
            
            for(int i=0;i<size ;i++){
                TreeNode curr = q.poll();
                if(curr.left!= null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    q.offer(curr.left);
                }
                 if(curr.right!= null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    q.offer(curr.right);
                }
                if(parent_map.get(curr)!= null && !vis.contains(parent_map.get(curr))){
                    vis.add(parent_map.get(curr));
                    q.offer(parent_map.get(curr));
                }
                
            }
            distance++;

        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
}