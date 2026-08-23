class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int n=pairs.length;
        int len=1;
        int last=pairs[0][1];
        for(int i=1;i<n;i++){
            if (last < pairs[i][0]) {
                len++;
                last = pairs[i][1];
            }
        }

        return len;
    }
}