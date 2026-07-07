/*
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public ArrayList<Integer> merge(Node root1, Node root2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                ans.add(list1.get(i));
                i++;
            } else {
                ans.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            ans.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            ans.add(list2.get(j));
            j++;
        }

        return ans;
    }
}