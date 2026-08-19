class pair{
    String word;
    int length;
    pair(String word,int length){
        this.word = word;
        this.length = length;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord)) return 0;
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(beginWord,1));

        st.remove(beginWord);

        while(!que.isEmpty()){
            String newWord = que.peek().word;
            int steps = que.peek().length;
            que.poll();

            if(newWord.equals(endWord)) return steps;
            for(int i=0;i<newWord.length();i++){
                for(char l='a';l<='z';l++){
                    char ch[] =  newWord.toCharArray();
                    ch[i] = l;
                    String nextWord = new String(ch);
                    if(st.contains(nextWord) == true){
                        que.offer(new pair(nextWord,steps+1));
                        st.remove(nextWord);
                    }
                }
            }
        }
        return 0;
    }
}