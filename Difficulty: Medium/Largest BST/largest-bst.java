// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    static class Info {
        int min;
        int max;
        int size;
        boolean isBST;

        Info(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static int largestBst(Node root) {
        return helper(root).size;
    }

    static Info helper(Node node) {

        if (node == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        Info left = helper(node.left);
        Info right = helper(node.right);

        if (left.isBST && right.isBST &&
            node.data > left.max && node.data < right.min) {

            int min = Math.min(left.min, node.data);
            int max = Math.max(right.max, node.data);
            int size = left.size + right.size + 1;

            return new Info(min, max, size, true);
        }

        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,
                        Math.max(left.size, right.size), false);
    }
}