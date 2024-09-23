class Solution {
    private int helper(String s,Set<String> h,int idx,int dp[]){
        if(idx == s.length()) return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i=idx;i<s.length();i++){
            sb.append(s.charAt(i));
            int extra = 0;
            if(!h.contains(sb.toString())) extra = sb.length();
            int next = helper(s,h,i+1,dp);
            ans = Math.min( ans,extra + next );
        }
        return dp[idx] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        int dp[] = new int[50];
        Arrays.fill(dp,-1);
        Set<String> h = new HashSet<>(Arrays.asList(dictionary));
        return helper(s,h,0,dp);
    }
}
