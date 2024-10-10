class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(s.isEmpty() || nums[s.peek()] > nums[i]){
                s.push(i);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                ans = Math.max(ans,i-s.pop());
            }
        }
        return ans;
    }
}
