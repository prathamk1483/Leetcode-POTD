
class Solution {
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 != null) return false;
        if(r1 != null && r2 == null) return false;
        if(r1 == null && r2 == null) return true;
        if(r1.val != r2.val) return false;
        int L1 = r1.left != null ? r1.left.val : -1,
            R1 = r1.right != null ? r1.right.val : -1,
            L2 = r2.left != null ? r2.left.val : -1,
            R2 = r2.right != null ? r2.right.val : -1;

        if(L1 == L2 && R1 == R2) return flipEquiv(r1.left , r2.left) && flipEquiv(r1.right , r2.right);
        else if(L1 == R2 && R1 == L2) return flipEquiv(r1.left , r2.right) && flipEquiv(r1.right , r2.left);
        return false;
    }
}
