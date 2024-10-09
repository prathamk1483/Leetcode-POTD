class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count =0;
        for(char i : s.toCharArray()){
            if(i == '(' ) st.push(i);
            else if(i == ')' && !st.isEmpty() && st.peek() == '(') st.pop();
            else st.push(i);
        }
        return st.size();
    }
}
