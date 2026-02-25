class Solution {

    // Push element at the back
    public static void pb(ArrayDeque<Integer> dq, int x) {
        dq.addLast(x);
    }

    // Pop element from the back
    public static void ppb(ArrayDeque<Integer> dq) {
        if (!dq.isEmpty()) {
            dq.removeLast();
        }
    }

    // Return front element of deque
    public static int front_dq(ArrayDeque<Integer> dq) {
        if (!dq.isEmpty()) {
            return dq.peekFirst();
        }
        return -1;
    }

    // Push element at the front
    public static void pf(ArrayDeque<Integer> dq, int x) {
        dq.addFirst(x);
    }
}