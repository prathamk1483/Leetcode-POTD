class Solution {
    private void subsets(int[] nums,int idx,int maxOR,int currOR, int[] ans){
        if(currOR == maxOR) ans[0]++;
        
        if(idx == nums.length) return;
        for(int i = idx;i<nums.length;i++){
            subsets(nums,i+1,maxOR,currOR | nums[i] ,ans);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int i:nums) maxOR |= i;
        int[] ans = new int[1];
        subsets(nums,0,maxOR,0,ans);
        return ans[0];
    }
}
