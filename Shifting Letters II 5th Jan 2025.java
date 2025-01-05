class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1]; // Difference array
        
        // Apply shifts using the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            shiftArray[start] += (direction == 1 ? 1 : -1);
            shiftArray[end + 1] -= (direction == 1 ? 1 : -1);
        }
        
        // Compute prefix sums for the final shifts
        int currentShift = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            currentShift += shiftArray[i];
            int originalCharIndex = s.charAt(i) - 'a';
            int newCharIndex = (originalCharIndex + currentShift) % 26;
            if (newCharIndex < 0) newCharIndex += 26; 
            result.append((char) ('a' + newCharIndex));
        }
        
        return result.toString();
    }
}
