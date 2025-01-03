class Solution {
    public int waysToSplitArray(int[] nums) {
        long pref = 0 , suf = 0 ;
        int count = 0;
        for(int i=nums.length-1;i>=0;i--) suf += nums[i];
        for(int i=0;i<nums.length-1;i++){
            pref += nums[i];
            suf -= nums[i];
            count += pref >= suf ? 1 : 0;
        }
        return count;
    }
}
