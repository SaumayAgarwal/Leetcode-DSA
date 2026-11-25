class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> map(256, -1);

        int left = 0;

        int maxLen=0;
        for(int right=0;right<s.length();right++){
            if(map[s[right]]<left){
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