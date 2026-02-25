import java.util.ArrayDeque;
import java.util.Iterator;

class Solution {

    // Remove element at index X
    public static void eraseAt(ArrayDeque<Integer> deq, int X) {
        if (X < 0 || X >= deq.size()) return;  // invalid index
        
        Iterator<Integer> it = deq.iterator();
        int index = 0;
        while (it.hasNext()) {
            it.next();
            if (index == X) {
                it.remove();
                break;
            }
            index++;
        }
    }

    // Remove elements in the range [start, end)
    public static void eraseInRange(ArrayDeque<Integer> deq, int start, int end) {
        if (start == end) return; // nothing to remove
        if (start < 0) start = 0;
        if (end > deq.size()) end = deq.size();
        
        Iterator<Integer> it = deq.iterator();
        int index = 0;
        while (it.hasNext()) {
            it.next();
            if (index >= start && index < end) {
                it.remove();
            }
            index++;
            if (index >= end) break; // stop after end
        }
    }

    // Remove all elements
    public static void eraseAll(ArrayDeque<Integer> deq) {
        deq.clear();
    }
}