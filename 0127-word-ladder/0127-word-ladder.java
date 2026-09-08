class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level=0;
        
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);

        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            int size=q.size();
            level++;

            for(int i=0;i<size;i++){
                String curr=q.poll();

                if(curr.equals(endWord))return level;

                for(int j=0;j<curr.length();j++){
                    char[] arr=curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        char c=arr[j];
                        arr[j]=ch;
                        String replaced=new String(arr);
                        if(set.contains(replaced)){
                            q.add(replaced);
                            set.remove(replaced);
                        }
                        arr[j]=c;
                    }
                }
            }
        }
        return 0;
    }
}