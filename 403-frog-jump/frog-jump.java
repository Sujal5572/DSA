class Solution {
    public boolean canCross(int[] stones) {
        // we store the jumps for every stones so that we can avoid the ovelapping subproblem case
        // tc will be O(n^2)as for every stones could have n possible jumps in set and we have to check for all jump in worst case 
        // sc will O(n^2)as we are storing jumps in set fro every stone entries in map 
        Map<Integer , Set<Integer>> map = new HashMap<>();
        for(int stone : stones){
            map.put(stone , new HashSet<>());
        }
        map.get(0).add(1);

        for(int stone : stones){
            for(int jump : map.get(stone)){
                int nextPos = jump + stone;
                if(nextPos == stones[stones.length -1])
                return true;
                if(map.containsKey(nextPos)){
                    if(jump-1>0)
                    map.get(nextPos).add(jump-1);
                    map.get(nextPos).add(jump);
                    map.get(nextPos).add(jump+1);
                }
            }
        }
        return false;

    }
}







        // tc will be O(3^n)as every stone we have 3 choices in worst we have to check for all 3
        // sc will be O(n)due to recursion stack space
//         return dfs(stones, 0, 0);
//     }

//     private boolean dfs(int[] stones, int index, int lastJump) {
//         if (index == stones.length - 1) {// if we reach the last index
//             return true;
//         }

//         for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
//             if (nextJump <= 0) continue;

//             int nextPosition = stones[index] + nextJump; // checking for k-1, k , k+1

//             for (int i = index + 1; i < stones.length; i++) {// start from lastindex+1
//                 if (stones[i] == nextPosition) {
//                     if (dfs(stones, i, nextJump)) {
//                         return true;
//                     }
//                 }
//             }
//         }

//         return false;
//     }
// }