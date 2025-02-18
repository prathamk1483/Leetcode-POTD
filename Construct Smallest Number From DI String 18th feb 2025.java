class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<pattern.length();i++){
            count += 1;
            if(pattern.charAt(i) == 'I'){
                ans.append(count);
                while(!st.isEmpty()){
                    ans.append(st.pop());
                }
                if(i == pattern.length()-1) ans.append(pattern.length()+1);
            }
            else{
                st.push(count);
                if(i == pattern.length()-1) st.push(pattern.length()+1);
            }
        }

        while(!st.isEmpty()) ans.append(st.pop());

        return ans.toString();
    }
}
