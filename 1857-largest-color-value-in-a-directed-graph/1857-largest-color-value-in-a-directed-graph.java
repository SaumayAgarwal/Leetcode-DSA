class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<Integer>[] adj=new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        int[] indegree=new int[n];

        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);

            indegree[edges[i][1]]++;
        }

        int[][] dp=new int[n][26];

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);

            dp[i][colors.charAt(i)-'a']++;
        }

        int ans=1;
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;

            for(int i:adj[curr]){
                char c=colors.charAt(i);
                for(char ch='a';ch<='z';ch++){
                    int idx=ch-'a';
                    dp[i][idx] = Math.max(
                        dp[i][idx],
                        dp[curr][idx] + (c == ch ? 1 : 0)
                    );
                    
                    ans=Math.max(ans, dp[i][idx]);
                }
                indegree[i]--;
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        if(count!=n)return -1;
        return ans;
    }
}