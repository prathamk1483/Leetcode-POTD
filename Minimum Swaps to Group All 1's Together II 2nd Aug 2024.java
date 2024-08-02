class Solution {
    public int minSwaps(int[] nums) {
        int winsize =0;
        for(int i:nums) winsize+=i;

        int cur =0;
        for(int i=0;i<winsize;i++){
            if(nums[i] == 0) cur++;
        }

        int end = winsize-1,ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;){
            if(nums[i] == 0) cur--;
            i++;
            end++;
            if(nums[end%nums.length] == 0) cur++;
            ans = Math.min(ans,cur);
        }
        return ans;
    }
}
