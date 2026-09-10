class Solution {
    public int dfs(int[] edges, int curr, int prev, boolean[] vis, boolean[] inRecur, int[] dist){

        if(inRecur[curr]){
            return dist[prev]-dist[curr]+1;
        }

        if(vis[curr]) {
            return -1;
        }

        vis[curr]=true;

        inRecur[curr]=true;
        if(prev!=-1)dist[curr]=dist[prev]+1;

        int ans=-1;
        if(edges[curr]==-1)ans=-1;
        else ans= dfs(edges, edges[curr], curr, vis, inRecur, dist);

        inRecur[curr]=false;
        if(prev!=-1)dist[curr]-=dist[prev]+1;
        return ans;
    }
    public int longestCycle(int[] edges) {
        int n=edges.length;

        boolean[] vis=new boolean[n];
        int[] dist=new int[n];
        boolean[] inRecur=new boolean[n];
        Arrays.fill(dist, 1);
        int max=-1;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                max=Math.max(max, dfs(edges, i, -1, vis, inRecur, dist));
            }
        }
        return max;
    }
}