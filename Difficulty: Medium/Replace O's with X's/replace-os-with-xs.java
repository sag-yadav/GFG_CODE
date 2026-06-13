class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public void dfs(char[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        
        // mark visited safe O
        grid[x][y] = '#';
        
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m 
                && grid[nx][ny] == 'O') {
                dfs(grid, nx, ny);
            }
        }
    }
    
    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Traverse boundary rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O')
                dfs(grid, 0, j);
            
            if (grid[n - 1][j] == 'O')
                dfs(grid, n - 1, j);
        }
        
        // Step 2: Traverse boundary columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O')
                dfs(grid, i, 0);
            
            if (grid[i][m - 1] == 'O')
                dfs(grid, i, m - 1);
        }
        
        // Step 3: Convert surrounded O -> X
        // and restore # -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                
                else if (grid[i][j] == '#')
                    grid[i][j] = 'O';
            }
        }
    }
}