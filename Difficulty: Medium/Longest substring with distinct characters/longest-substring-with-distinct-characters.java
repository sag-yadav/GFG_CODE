class Solution {
    public int longestUniqueSubstr(String s) {
        int[] lastSeen = new int[26];
        
        // Initialize with -1
        for (int i = 0; i < 26; i++) {
            lastSeen[i] = -1;
        }

        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // If character already exists in current window
            if (lastSeen[ch - 'a'] >= start) {
                start = lastSeen[ch - 'a'] + 1;
            }

            // Update last seen index
            lastSeen[ch - 'a'] = end;

            // Update maximum length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}