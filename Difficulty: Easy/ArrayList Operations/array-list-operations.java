class Solution {

    public static void add_to_ArrayList(ArrayList<Integer> A, int x) {
        // Add element at the end
        A.add(x);
    }

    public static void sort_ArrayList_Asc(ArrayList<Integer> A) {
        // Sort in ascending order
        Collections.sort(A);
    }

    public static void reverse_ArrayList(ArrayList<Integer> A) {
        // Reverse ArrayList
        Collections.reverse(A);
    }

    public static int size_Of_ArrayList(ArrayList<Integer> A) {
        // Return size
        return A.size();
    }

    public static void sort_ArrayList_Desc(ArrayList<Integer> A) {
        // Sort in descending order
        Collections.sort(A, Collections.reverseOrder());
    }

    public static void print_ArrayList(ArrayList<Integer> A) {
        // Print elements separated by space
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
    }
}