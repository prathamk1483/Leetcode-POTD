class Solution {
    static List<Integer> jugglerSequence(int n) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(1);
            return ans;
        }
        ans.add(n);
        int i=1,last =n;
        while(true){
            double num =0;
            if( last%2 == 0){
                num = Math.pow( last ,0.5 );
                last = (int)num;
                ans.add((int)num);
            }
            else if(last%2 != 0){
                num = Math.pow( last ,1.5 );
                last = (int)num;
                ans.add((int)num);
            }
            if( last  == 1) break;
            i++;
        }
        return ans;
    }
}
