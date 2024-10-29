class Solution {
    private boolean isSafe(int r , int c,int[][] mat){
        if(r < 0 || r >= mat.length || c < 0 || c >= mat[0].length) return false;
        return true;
    }
    private int helper(int[][] mat,int r , int c,int[][] dp){
        int tr = 0;
        if(isSafe(r,c,mat) && dp[r][c] != -1) return dp[r][c];
        if(isSafe(r-1,c+1,mat) && mat[r-1][c+1] > mat[r][c])tr = helper(mat,r-1,c+1,dp);
        int ri = 0;
        if(isSafe(r,c+1,mat) && mat[r][c+1] > mat[r][c])ri =helper(mat , r, c+1,dp);
        int br = 0;
        if(isSafe(r+1,c+1,mat) && mat[r+1][c+1]> mat[r][c] )br =helper(mat,r+1,c+1,dp);

        return dp[r][c] = 1 + Math.max(br , Math.max(ri,tr));
    }
    public int maxMoves(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[grid.length+1][grid[0].length+1];
        for(int i[] :dp) Arrays.fill(i,-1);
        for(int i=0;i<grid.length;i++){
            int res = helper(grid,i,0,dp);
            ans = Math.max(ans,res);
        }
        return ans-1;
    }
}
