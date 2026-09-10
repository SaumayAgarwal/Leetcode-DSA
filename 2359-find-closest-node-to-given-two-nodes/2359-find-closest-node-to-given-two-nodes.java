class Solution {

    public void bfs(int[] dist, int start, int[] edges){
        Arrays.fill(dist, (int)1e9);
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        dist[start]=0;

        while(!q.isEmpty()){
            int curr = q.poll();

            int next = edges[curr];

            if (next != -1 && dist[next] == (int)1e9) {
                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        
        int[] dist1=new int[n];
        int[] dist2=new int[n];
        bfs(dist1, node1, edges);
        bfs(dist2, node2, edges);

        int[] max=new int[n];
        int min=(int)1e9;
        int ans=-1;

        for(int i=0;i<n;i++){
            max[i]=Math.max(dist1[i], dist2[i]);
            if(min>max[i]){
                min=max[i];
                ans=i;
            }
        }

        return ans;        
    }
}