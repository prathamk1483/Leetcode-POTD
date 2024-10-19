class Solution {
    private StringBuilder helper(StringBuilder s1){
        StringBuilder invert = new StringBuilder();
        for(char i :s1.toString().toCharArray())invert.append( i == '1' ? '0' : '1' );
        return s1.append("1").append(invert.reverse());
    }
    public char findKthBit(int n, int k) {
        StringBuilder s1 = new StringBuilder("0");
        while(n-- > 1){
            s1 = helper(s1);
        }
        return s1.charAt(k-1);
    }
}
