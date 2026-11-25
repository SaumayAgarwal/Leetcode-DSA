class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;

        int left = 0;

        int maxLen=0;
        for(int right=0;right<s.length();right++){
            if(map.count(s[right]) == 0 || map[s[right]]<left){
                maxLen = max(maxLen, right - left + 1);
            }

            else{
                left=map[s[right]]+1;
            }
            map[s[right]]=right;
        }

        return maxLen;
    }
};