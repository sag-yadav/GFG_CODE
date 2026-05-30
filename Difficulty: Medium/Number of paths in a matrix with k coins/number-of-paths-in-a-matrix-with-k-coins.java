class Solution {
    
    int[][][] dp;
    
    private int solve(int[][] mat, int i, int j, int k) {
        
        if (k < 0) return 0;
        
        if (i == 0 && j == 0) {
            return (k == mat[0][0]) ? 1 : 0;
        }
        
        if (i < 0 || j < 0) return 0;
        
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        
        int ways = solve(mat, i - 1, j, k - mat[i][j]) +
                   solve(mat, i, j - 1, k - mat[i][j]);
        
        return dp[i][j][k] = ways;
    }
    
    public int numberOfPath(int[][] mat, int k) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        dp = new int[n][m][k + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }
        
        return solve(mat, n - 1, m - 1, k);
    }
}