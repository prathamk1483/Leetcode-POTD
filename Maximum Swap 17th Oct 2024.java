class Solution {
    public int maximumSwap(int num) {
        char[] a1 = Integer.toString(num).toCharArray();

        int b = Integer.MIN_VALUE , s = -1 , bi =  -1 ,bii=-1, si = -1;
        for(int i = a1.length-1;i>=0;i--){
            if(a1[i]-'0' > b){
                b = a1[i]-'0';
                bi = i;
            }
            else if(a1[i]-'0' < b){
                si = i;
                bii =bi;
            }
        }
        if(si != -1 && bi != -1){
            char temp = a1[si];
            a1[si] = a1[bii];
            a1[bii] = temp;
        }

        return Integer.parseInt(new String(a1));
    }
}
