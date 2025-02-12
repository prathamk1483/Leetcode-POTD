class Solution {
    public long sum(String n){
        long sum = 0;
        for(char i :n.toCharArray()) sum += (i-'0');
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Long,Integer> mp = new HashMap<>();
        int ans = -1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            long digitSum = sum(Integer.toString(nums[i]));
            if(mp.containsKey(digitSum)){
                ans = Math.max(ans,mp.get(digitSum) + nums[i]);
            }
            mp.put(digitSum , nums[i]);
        }
        return ans;
    }
}
