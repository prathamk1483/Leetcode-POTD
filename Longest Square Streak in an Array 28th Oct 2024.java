class Solution {
    public int longestSquareStreak(int[] nums) {
        if(nums.length < 2) return -1;
        Map<Long, Boolean> m = new HashMap<>();
        Arrays.sort(nums);
        for(int i: nums) m.put((long)i,false);

        int start = nums[0],i=1,len=1,ans = -1;
        while(i<nums.length){
            ans = Math.max(ans,len);
            if(m.get((long)start*start) != null && m.get((long)start*start) != true){ 
                len++;
                start = start*start;
                continue;
            }
            else len =1;
            start =  nums[i++];
        }
        return ans >= 2 ? ans : -1;
    }
}
