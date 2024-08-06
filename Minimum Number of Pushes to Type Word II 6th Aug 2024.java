class Solution {
    public int minimumPushes(String word) {
        int count[] = new int[26];
        for(char i:word.toCharArray()) count[i-'a']++;
        
        Arrays.sort(count);
        
        int ans =0;

        for(int i=0;i<26;i++){
            ans += (((26-i-1)/8)+1)*count[i]; 
        }

        return ans;
    }
}
