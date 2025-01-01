class Solution {
    public int maxScore(String s) {
        int ans = 0,z = 0 , o = 0;
        for(char i : s.toCharArray()){
            o += i == '1' ? 1 : 0;
        }
        for(int j = 0 ; j < s.length()-1;j++){
            char i = s.charAt(j);
            if(i == '1'){ 
                o--;
            }
            else if(i == '0') z++;
            ans = Math.max(z+o,ans);
        }
        return ans;
    }
}


 
