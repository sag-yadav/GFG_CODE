class Solution {
    public boolean wildCard(String txt, String pat) {
        
        int n = pat.length();
        int m = txt.length();
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Empty pattern matches empty string
        dp[0][0] = true;
        
        // Handle patterns like *, **, ***
        for (int i = 1; i <= n; i++) {
            if (pat.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                char p = pat.charAt(i - 1);
                char t = txt.charAt(j - 1);
                
                // Exact match or '?'
                if (p == t || p == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                
                // '*'
                else if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[n][m];
    }
}