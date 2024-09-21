class Solution {
    private void dfs(int num,int n , List<Integer> ans){
        if(num > n) return;
        ans.add(num);
        for(int i=0;i<10;i++){
            if((num*10 + i) > n) break;
            dfs(num*10 + i,n,ans);
        }
        return ;
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i > n) break;
            dfs(i,n,l);
        }
        return l;
    }
}
