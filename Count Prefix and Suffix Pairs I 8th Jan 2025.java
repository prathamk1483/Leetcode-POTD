class Solution {
    private boolean helper(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        if (n1 > n2) return false;
        for (int i=0;i<n1;i++) {
            if (s1.charAt(i) != s2.charAt(i))return false;
        }
        
        for (int i=0;i<n1;i++) {
            if (s1.charAt(i) != s2.charAt(n2 - n1 + i)) return false;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for (int i = 0; i<words.length;i++) {
            for (int j = i + 1;j<words.length; j++) {
                if (helper(words[i], words[j])) count++;
            }
        } 
        return count;
    }
    
}
