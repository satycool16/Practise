public class TreeTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void printPostorder(Node root){
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void printPreorder(Node root){
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);

    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        printInorder(node);
        System.out.println();
        printPreorder(node);
        System.out.println();
        printPostorder(node);
    }
}
