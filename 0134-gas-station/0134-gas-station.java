class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0;
        int currentGas=0;
        int startIndex=0;
        int n=gas.length;
        for(int i=0;i<n;i++){
            currentGas+=gas[i]-cost[i];
            totalGas+=gas[i];
            totalCost+=cost[i];

            if(currentGas<0){
                currentGas=0;
                startIndex=i+1;
            }
        }

        if(totalGas<totalCost)return -1;
        return startIndex;
    }
}