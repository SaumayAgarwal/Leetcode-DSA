class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr, (a, b)->a[0]-b[0]);

        double[] timeToReach=new double[n];

        for(int i=0;i<n;i++){
            timeToReach[i]=(double)(target - arr[i][0])/arr[i][1];
        }

        int ans=1;
        double prev=timeToReach[n-1];
        for(int i=n-2;i>=0;i--){
            if(timeToReach[i]>prev){
                prev=timeToReach[i];    
                ans++;
            }
        }
        return ans;
    }
}