class Solution {
    private int[] hashValue(String s) {
        int[] freq = new int[26];  
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] h1 = hashValue(s1); 
        int[] h2 = hashValue(s2.substring(0, s1.length()));  
        if (matches(h1, h2)) {
            return true;
        }
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            h2[s2.charAt(i - 1) - 'a']--;  
            h2[s2.charAt(i + s1.length() - 1) - 'a']++;  
            if (matches(h1, h2)) {
                return true;
            }
        }
        return false;
    }
    private boolean matches(int[] h1, int[] h2) {
        for (int i = 0; i < 26; i++) {
            if (h1[i] != h2[i]) {
                return false;
            }
        }
        return true;
    }
}
