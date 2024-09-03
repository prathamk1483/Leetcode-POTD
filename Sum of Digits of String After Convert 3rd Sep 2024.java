class Solution {
    public int getLucky(String s, int k) {
        StringBuilder temp = new StringBuilder();
        for(char i:s.toCharArray()){
            temp.append((int)(i-'a'+1));
        }
        String t = temp.toString();
        while(k-- >0){
            int sum =0;
            for(char i : t.toCharArray()){
                sum += (i-'0');
            }
            t = Integer.toString(sum);
        }

        return Integer.parseInt(t);
    }
}
