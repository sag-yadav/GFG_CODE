
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        
        int n = start.length;
        
        // Store activities as {start, finish}
        int[][] activities = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }
        
        // Sort by finish time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int lastFinish = activities[0][1];
        
        // Select activities greedily
        for (int i = 1; i < n; i++) {
            if (activities[i][0] > lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }
        
        return count;
    }
}

