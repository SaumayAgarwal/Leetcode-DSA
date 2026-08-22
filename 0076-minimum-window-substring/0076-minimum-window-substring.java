class Solution {
    public String minWindow(String s, String t) {
        int left=0;
        Map<Character, Integer> map=new HashMap<>();
        int n=t.length();
        for(int i=0;i<n;i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int k=n;
        int ans=(int)1e9;
        int maxi=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);

            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)-1);
                if(map.get(ch)>=0)k--;
            }

            while(k==0){
                char temp=s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.getOrDefault(temp, 0)+1);
                    if(map.get(temp)>0)k++;
                }
                if(ans>right-left+1){
                    ans=right-left+1;
                    maxi=left;
                }
                left++;
            }
        }
        if(ans==(int)1e9)return "";
        return s.substring(maxi, maxi+ans);
    }
}