class Solution {
    public String colName(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--; // Adjust because Excel columns are 1-based

            int rem = n % 26;
            result.append((char) ('A' + rem));

            n = n / 26;
        }

        return result.reverse().toString();
    }
}