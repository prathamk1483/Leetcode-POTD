class Solution {
    private boolean helper(String s1, String s2) {
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");
        
        int len1 = a1.length;
        int len2 = a2.length;
        int i = 0, j = len2 - 1;
        while (i < len2 && a1[i].equals(a2[i])) {
            i++;
        }
        while (j >= 0 && a1[len1 - (len2 - j)].equals(a2[j])) {
            j--;
        }
        return i > j;
    }
    
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() >= s2.length()) {
            return helper(s1, s2);
        }
        return helper(s2, s1);
    }
}
