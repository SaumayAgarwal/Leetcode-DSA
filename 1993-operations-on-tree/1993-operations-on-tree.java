class LockingTree {
    int[] lock;
    int n;
    List<Integer>[] adj;
    Set<Integer>[] locked;
    int[] parent;
    
    public LockingTree(int[] parent) {
        n=parent.length;
        lock=new int[n];
        Arrays.fill(lock, -1);
        adj=new ArrayList[n];
        locked=new HashSet[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            locked[i]=new HashSet<>();
        }
        for(int i=1;i<n;i++){
            adj[parent[i]].add(i);
        }

        this.parent=parent;

    }
    
    public boolean lock(int num, int user) {
        if(lock[num]==-1){
            lock[num]=user;
            int j=parent[num];
            while(j!=-1){
                locked[j].add(num);
                j=parent[j];
            }
            return true;
        }
        
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num]==user){
            lock[num]=-1;
            int j=parent[num];
            while(j!=-1){
                locked[j].remove(num);
                j=parent[j];
            }
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user){
        int j=num;
        while(parent[j]!=-1){
            if(lock[j]!=-1)return false;
            j=parent[j];
        }

        if(lock[j]!=-1)return false;

        Queue<Integer> q=new LinkedList<>();
        q.add(num);

        // List<Integer> locked=new ArrayList<>();
        // while(!q.isEmpty()){
        //     int size=q.size();

        //     for(int i=0;i<size;i++){
        //         int curr=q.poll();
        //         if(lock[curr]!=-1){
        //             locked.add(curr);
        //         }

        //         for(int k:adj[curr]){
        //             q.add(k);
        //         }
        //     }
        // }



        if(locked[num].size()!=0){
            for(int i : new ArrayList<>(locked[num])){
                unlock(i, lock[i]);
            }
            lock(num, user);
            return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */