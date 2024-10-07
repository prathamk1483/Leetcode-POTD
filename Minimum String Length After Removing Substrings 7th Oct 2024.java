class Solution {
    public int minLength(String st) {
        Stack<Character> s = new Stack<>();
        for(char i:st.toCharArray()){
            if(i == 'B' && !s.isEmpty() && s.peek() == 'A') s.pop();
            else if(i == 'D' && !s.isEmpty() && s.peek() == 'C') s.pop();
            else s.push(i);
        }
        return s.size();
    }
}
