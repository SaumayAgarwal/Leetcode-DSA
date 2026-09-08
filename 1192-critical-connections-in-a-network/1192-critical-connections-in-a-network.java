class Solution {

    List<List<Integer>> ans;
    int t=1;
    int[] time;
    int[] low;

    public void dfs(List<Integer>[] adj, int curr, int prev, boolean[] vis){
        vis[curr]=true;

        time[curr]=t;
        low[curr]=t;
        t++;

        for(int i: adj[curr]){
            if(!vis[i]){
                dfs(adj, i, curr, vis);
            }

            if(i!=prev){
                low[curr]=Math.min(low[curr], low[i]);
                if(time[curr]<low[i])ans.add(new ArrayList<>(List.of(curr, i)));
            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj=new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<connections.size();i++){
            adj[connections.get(i).get(0)].add(connections.get(i).get(1));
            adj[connections.get(i).get(1)].add(connections.get(i).get(0));
        }

        time=new int[n];
        low=new int[n];

        ans=new ArrayList<>();
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i])dfs(adj, i, -1, vis);
        }
        return ans;
    }
}