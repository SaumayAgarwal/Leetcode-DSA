class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<int> set;

        int left = 0;

        int maxLen=0;
        for(int right=0;right<s.length();right++){
            if(set.count(s[right])==0){
                set.insert(s[right]);
                maxLen = max(maxLen, right - left + 1);
            }

            else{
                while(set.count(s[right])){
                    set.erase(s[left]);
                    left++;
                }
                set.insert(s[right]);
            }
        }

        return maxLen;
    }
};