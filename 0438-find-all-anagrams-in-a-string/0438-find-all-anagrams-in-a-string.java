class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map=new int[26];

        int k=p.length();
        int n=0;
        for(int i=0;i<k;i++){
            map[p.charAt(i) - 'a']++;
            if(map[p.charAt(i) - 'a']==1)n++;
        }

        int left=0;
        List<Integer> ans=new ArrayList<>();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

            map[ch - 'a']--;
            if(map[ch-'a']==0)n--;
            while(map[ch-'a']<0 || n==0){
                if(n==0)ans.add(left);
                char temp=s.charAt(left);
                map[temp-'a']++;
                if(map[temp-'a']==1)n++;
                left++;
            }
        }
        return ans;
    }
}