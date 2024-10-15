class Solution {
    public long minimumSteps(String s) {
        int right = s.length() - 1;
        long ans = 0;
        while (right >= 0 && s.charAt(right) == '1') right--;
        for (int i = right - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ans += (right - i);
                right--; 
            }
        }
        return ans;
    }
}
