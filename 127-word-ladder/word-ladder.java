class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // tc(N*L*26)N-> wl.size() and l -> begin.length; and 26 charcter 
        // sc(N*L) as set N words each with length L
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                // base case
                if(word.equals(endWord))
                return level;
                char chars[] = word.toCharArray();
                for(int j=0;j<chars.length;j++){
                    char original = chars[j];
                    for(char c = 'a';c<='z';c++){
                        chars[j] = c;
                        String nextword = new String(chars);
                        if(set.contains(nextword)){
                            q.add(nextword);
                            set.remove(nextword);
                        }
                    }
                    chars[j]=original;
                }
            }
            level++;

        }
        return 0;

        
    }
}