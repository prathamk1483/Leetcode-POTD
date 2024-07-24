class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] helper = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            String num = Integer.toString(nums[i]);
            StringBuilder number = new StringBuilder();
            for(int j=0;j<num.length();j++){
                number.append(mapping[num.charAt(j)-'0']);
            }
            helper[i][0] = nums[i];
            helper[i][1] = Integer.parseInt(number.toString());
        }
        Arrays.sort(helper,Comparator.comparingInt(x ->x[1]));
        int ans[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = helper[i][0];
        }
        return ans;
    }
}
