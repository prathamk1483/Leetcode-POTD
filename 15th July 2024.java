
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        if(descriptions.length == 1){
            if(descriptions[0][2] == 1) return new TreeNode(descriptions[0][0],new TreeNode(descriptions[0][1]),null);
            else return new TreeNode(descriptions[0][0],null,new TreeNode(descriptions[0][1]));
        }
        Map<Integer , TreeNode> m = new HashMap<>();
        TreeNode root = null;
        Set<Integer> children = new HashSet<>();
        for(int i[] :descriptions){
            if(m.containsKey(i[0])) root = m.get(i[0]);
            else{
                root = new TreeNode(i[0]);
                m.put(i[0],root);
            }
            TreeNode temp = null;
            if(i[2]==1){
                temp = m.containsKey(i[1]) ? m.get(i[1]) : new TreeNode(i[1]);
                root.left = temp;
                m.put(i[1],temp);
            }
            else{
                temp = m.containsKey(i[1]) ? m.get(i[1]) : new TreeNode(i[1]);
                root.right = temp;
                m.put(i[1],temp);
            }
            children.add(i[1]);
        }
        int parent = -1;
        for(int i[]:descriptions){
            if(!children.contains(i[0])) parent = i[0];
        }

        return m.get(parent);
    }
}
