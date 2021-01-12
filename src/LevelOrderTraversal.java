public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    Node root;
    int height(Node root){
        if (root == null)
            return 0;
        else {
            int lh = height(root.left);
            int rh = height(root.right);
            if (lh > rh)
                return lh + 1;
            else
                return rh + 1;
        }
    }
    void printGivenLevel(Node root, int h){
        if (root == null)
            return;
        if (h == 1){
            System.out.println(root.data + " ");
        }
        else if (h> 1){
            printGivenLevel(root.left, h-1);
            printGivenLevel(root.right, h-1);
        }
    }
    void printLevelOrder(){
        int h =height(root);
        System.out.println("height"+ h);
        for (int i=1; i<=h; i++){
            printGivenLevel(root, i);
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}
