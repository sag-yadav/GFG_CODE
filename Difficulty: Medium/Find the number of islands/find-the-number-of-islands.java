class Solution {
    
    // 8 possible directions
    int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int countIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Start DFS if land and unvisited
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, boolean[][] visited,
                     int row, int col, int n, int m) {
        
        visited[row][col] = true;
        
        // Visit all 8 neighbors
        for (int k = 0; k < 8; k++) {
            
            int newRow = row + rowDir[k];
            int newCol = col + colDir[k];
            
            if (isValid(grid, visited, newRow, newCol, n, m)) {
                dfs(grid, visited, newRow, newCol, n, m);
            }
        }
    }
    
    private boolean isValid(char[][] grid, boolean[][] visited,
                            int row, int col, int n, int m) {
        
        return row >= 0 && row < n &&
               col >= 0 && col < m &&
               grid[row][col] == 'L' &&
               !visited[row][col];
    }
}