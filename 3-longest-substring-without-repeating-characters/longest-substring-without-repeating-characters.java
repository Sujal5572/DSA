class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int maxLen =0;
        Map<Character , Integer> map = new HashMap<>();
        int start =0;
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start ,map.get(c)+1);
            }
            map.put(c,i);
            int len = i-start +1;
            maxLen = Math.max(len,maxLen);

        }

        // //here tc will be O(n^2)
        // //scO(1);
        // for(int i=0;i<n;i++){
        //     int hash[] =new int[256];
        //     Arrays.fill(hash, 0);
        //     for(int j=i;j<n;j++){
        //         if(hash[s.charAt(j)]==1)break;
        //         hash[s.charAt(j)]=1;
        //         int len = j-i+1;
        //         maxLen = Math.max(len,maxLen);
        //     }
        // }
        return maxLen;
        
    }
}