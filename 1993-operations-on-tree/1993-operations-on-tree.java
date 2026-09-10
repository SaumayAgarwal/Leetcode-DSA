class LockingTree {
    int[] lock;
    int n;
    Map<Integer, List<Integer>> map;
    int[] parent;
    public LockingTree(int[] parent) {
        n=parent.length;
        lock=new int[n];
        Arrays.fill(lock, -1);
        map=new HashMap<>();
        for(int i=1;i<n;i++){
            List<Integer> l = map.getOrDefault(parent[i], new ArrayList<>());
            l.add(i);
            map.put(parent[i], l);
        }

        this.parent=parent;

    }
    
    public boolean lock(int num, int user) {
        if(lock[num]==-1){
            lock[num]=user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num]==user){
            lock[num]=-1;
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

        List<Integer> locked=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            boolean check=false;

            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(lock[curr]!=-1){
                    locked.add(curr);
                }

                for(int k:map.getOrDefault(curr, new ArrayList<>())){
                    q.add(k);
                }
            }
        }

        if(locked.size()!=0){
            for(int i:locked)lock[i]=-1;
            lock[num]=user;
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