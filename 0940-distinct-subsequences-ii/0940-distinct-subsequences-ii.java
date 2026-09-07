class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        long[] dp=new long[n+1];

        Map<Character, Integer> map=new HashMap<>();

        Arrays.fill(dp, 1);
        dp[0]=0;
        for(int i=1;i<=n;i++){

            char ch=s.charAt(i-1);
            for(int j=0;j<i;j++){
                dp[i]+=dp[j];
                dp[i]%=1000000007;
            }
            if(map.containsKey(ch)){
                dp[map.get(ch)]=0;
            }
            map.put(ch, i);
        }

        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=dp[i];
            sum%=1000000007;
        }

        return sum;
    }
}