class Solution {
    class dsu{
        int n;
        static int[] rank;
        static int[] parent;

        dsu(int n){
            this.n=n;
            rank=new int[n+1];
            parent=new int[n+1];

            for(int i=0;i<=n;i++){
                rank[i]=0;
                parent[i]=i;
            }
        }

        public static int findPar(int x){
            if(parent[x]==x)return x;

            return parent[x]=findPar(parent[x]);
        }

        public static void union(int x, int y){
            int p_x=findPar(x);
            int p_y=findPar(y);

            if(p_x!=p_y){
                if(rank[p_x]<rank[p_y]){
                    parent[p_x]=p_y;
                }
                else if(rank[p_x]>rank[p_y])parent[p_y]=p_x;
                else{
                    parent[p_y]=p_x;
                    rank[p_x]++;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        dsu d=new dsu(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i+1, j+1);
                }
            }
        }

        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(dsu.findPar(i+1));
        }

        return set.size();
    }
}