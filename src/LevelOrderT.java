public class LevelOrderT {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			this.left = this.right = null;

		}
	}
	private static void print_level(Node root, int level){
		if(root == null)
			return;
		if(level == 1){
			System.out.print(root.data);
			return;
		}
		print_level(root.left, level-1);
		print_level(root.right, level-1);
	}

	private static void printLevelOrder(Node root){
		for (int i=1; i <= height(root); i++){
			print_level(root, i);
			System.out.println();
		}
	}

	private static int height(Node root){
		if(root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight)
			return lheight+1;
		else
			return rheight+1;
	}

	public static void main(String args[])
	{
		Node tree = new Node(1);
		tree.left= new Node(2);
		tree.right= new Node(3);
		tree.left.left= new Node(4);
		tree.left.right= new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		printLevelOrder(tree);
	}
}
