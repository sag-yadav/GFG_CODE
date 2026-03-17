class Solution {
    public int longestKSubstr(String s, int k) {
        int left = 0, maxLen = -1;
        int[] freq = new int[26];
        int distinct = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Add current character
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinct++;
            }
            freq[s.charAt(right) - 'a']++;
            
            // Shrink window if distinct > k
            while (distinct > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            
            // Update answer when exactly k distinct chars
            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}