class Solution {
    private void helper(Node root,List<Integer> ans){
        if(root == null) return;
        for(Node i:root.children)
            helper(i,ans);
        ans.add(root.val);
        return;
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }
}
