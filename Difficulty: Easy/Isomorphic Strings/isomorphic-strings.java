class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] map1 = new int[26]; // s1 -> s2
        int[] map2 = new int[26]; // s2 -> s1
        
        // Initialize with -1 (means not mapped yet)
        for (int i = 0; i < 26; i++) {
            map1[i] = -1;
            map2[i] = -1;
        }

        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';

            // If neither character is mapped yet
            if (map1[c1] == -1 && map2[c2] == -1) {
                map1[c1] = c2;
                map2[c2] = c1;
            }
            // If mapping is inconsistent
            else if (map1[c1] != c2 || map2[c2] != c1) {
                return false;
            }
        }

        return true;
    }
}