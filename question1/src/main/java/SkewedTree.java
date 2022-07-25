public class SkewedTree {
    private static Node node;
    private static Node head;
    private static Node previous;

    public static void main(String[] args) {

        SkewedTree tree = new SkewedTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        transformBstToSkewedTree(node);
        traverseSkewedTree(head);
    }

    private static void traverseSkewedTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        traverseSkewedTree(root.right);
    }

    private static void transformBstToSkewedTree(Node root) {
        if (root == null) return;

        transformBstToSkewedTree(root.left);

        Node right = root.right;

        if (head == null) {
            head = root;
        } else {
            previous.right = root;
        }
        root.left = null;
        previous = root;

        transformBstToSkewedTree(right);
    }
}


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
