class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] helper = new int[words.length];
        for(int i=0;i<words.length;i++){
            String temp = words[i];
            char f = words[i].charAt(0);
            char l = words[i].charAt(words[i].length()-1);

            if( (f =='a' || f == 'e' || f == 'i' || f == 'o' || f == 'u')
            &&  (l =='a' || l == 'e' || l == 'i' || l == 'o' || l == 'u')){
                if(i > 0){
                    helper[i] = helper[i-1] + 1;
                }
                else{
                    helper[i] = 1;
                }
            }
            else{
                if(i > 0) helper[i] = helper[i-1];
                else helper[i] = 0;
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for(int[] i : queries){
            int l = i[0] , h = i[1];
            int rightcount = helper[h];
            int res = 0;
            if(l > 0) res = rightcount - helper[l-1];
            else res = rightcount;

            ans[idx++] = res;
        }

        return ans;
    }
}
