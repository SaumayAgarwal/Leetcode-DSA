class Solution {

    public int bs(int[] nums, int target, int right){
        int left=1;
        while(left<right){
            int mid=left+(right-left)/2;

            if(nums[mid]>=target)right=mid;
            else left=mid+1;
        }
        return left;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] tails=new int[n+1];

        int maxLen=1;
        tails[1]=nums[0];
        for(int i=0;i<n;i++){
            if(tails[maxLen]==nums[i])continue;
            if(tails[maxLen]<nums[i]){
                tails[++maxLen]=nums[i];
            }
            else{
                int idx=bs(tails, nums[i], maxLen);
                tails[idx]=nums[i];
            }
        }
        return maxLen;
    }
}