class Solution {
    public static int rec(int i, int j,int[][] matrix,int[][] dp){
        if(i<0 || j<0 || matrix[i][j]==0) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int left = rec(i,j-1,matrix,dp);
        int top = rec(i-1,j,matrix,dp);
        int diagonal = rec(i-1,j-1,matrix,dp);
        dp[i][j] = 1 + Math.min(left,Math.min(top,diagonal));
        return dp[i][j];
    }
    public int countSquares(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans += rec(i,j,matrix,dp);
            }
        }
        return ans;
    }
}
