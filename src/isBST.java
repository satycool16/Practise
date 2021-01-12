public class isBST {
	static class Node{
		int data;
		Node left, right;
		Node(int key){
			this.data = key;
			this.left = this.right = null;
		}
	}
	static boolean isBST(Node root, int min, int max){
		if(root == null)
			return true;

		if(root.data > max || root.data < min)
			return false;

		return isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max);
	}
	public static void main(String args[])
	{
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		if (isBST(root,-1,10))
			System.out.print("Is BST");
		else
			System.out.print("Not a BST");
	}
}
