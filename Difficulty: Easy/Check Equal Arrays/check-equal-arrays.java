
class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of elements in array a
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Decrease frequency using array b
        for (int num : b) {
            if (!map.containsKey(num)) {
                return false;
            }

            map.put(num, map.get(num) - 1);

            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return map.isEmpty();
    }
}