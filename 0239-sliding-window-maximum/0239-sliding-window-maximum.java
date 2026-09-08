class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();

        int[] ans=new int[nums.length-k+1];
        int l=0;
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i+1>=k){
                while(dq.peekFirst() < i-k+1)dq.pollFirst();
                ans[l++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}