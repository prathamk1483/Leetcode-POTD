class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int i=0,j=0;
        int[][] mat = new int[rowSum.length][colSum.length];
        while(i<rowSum.length && j < colSum.length){
            int ans = Math.min(rowSum[i],colSum[j]);
            mat[i][j] = ans;
            rowSum[i]-=ans;
            colSum[j]-=ans;
            if(rowSum[i] == 0) i++;
            else j++;
        }
        return mat;
    }
}
