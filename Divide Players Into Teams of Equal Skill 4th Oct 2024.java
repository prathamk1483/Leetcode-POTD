class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort( skill );
        int n = skill.length-1;
        int req = skill[0] + skill[n];  
        long ans =0;
        for(int i=0;i<=n/2;i++){
            if(skill[i] + skill[n-i] != req) return -1;
            ans += skill[i]*skill[n-i];
        }
        return ans;
    }
}
