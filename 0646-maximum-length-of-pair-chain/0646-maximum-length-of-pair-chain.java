class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int n=pairs.length;
        int len=1;
        for(int i=0;i<n;i++){
            int curLen=1;
            int b=pairs[i][1];
            for(int j=i+1;j<n;j++){
                if(b<pairs[j][0]){
                    curLen++;
                    b=pairs[j][1];
                }
            }
            len=Math.max(len, curLen);
        }

        return len;
    }
}