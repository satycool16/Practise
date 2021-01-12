public class RightView {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    Node root;
    int max_level = 0;

    public void rightView(){
        rightViewUtil(root, 1);

    }
    public void rightViewUtil(Node root, int level){
        if (root == null)
            return;
        if (level> max_level){
            System.out.println(root.data);
            max_level = level;
        }
        rightViewUtil(root.right, level+1);
        rightViewUtil(root.left, level+1);

    }
    public static void main(String[] args) {
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        tree.rightView();
    }
}
