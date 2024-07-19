class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        Map<Integer,Integer> helper = new HashMap<>();
        
        for(int i=0;i<mat.length;i++){
            int min = Integer.MAX_VALUE;
            int col = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] < min){
                    min = mat[i][j];
                    col = j;
                }
            }
            helper.put(min,col);
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> m : helper.entrySet()){
            int el = m.getKey();
            int col = m.getValue();
            boolean flag = true;
            for(int i=0;i<mat.length;i++){
                if(mat[i][col] > el){
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(el); 
        }
        return ans;
    }
}
