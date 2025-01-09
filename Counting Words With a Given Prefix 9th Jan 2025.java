class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String i : words){
            if(i.indexOf(pref) == 0) ans++;
        }
        return ans;
    }
}
