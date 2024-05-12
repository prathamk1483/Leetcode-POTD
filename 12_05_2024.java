class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
            int start =1,end = grid.length-1;
            for(int i=start;i<end;i++){
                for(int j=start;j<end;j++){
                    int temp = Integer.MIN_VALUE;
                    for(int k = i - 1; k <= i + 1; ++k) {
                        for(int l = j - 1; l <= j + 1; ++l) {
                            temp = Math.max(temp, grid[k][l]);
                        }
                    }
                    res[i - 1][j - 1] = temp;
                }
            }
        
        return res;
    }
}
