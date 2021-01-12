import java.util.Queue;
import java.util.LinkedList;
public class LOTwithQ {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			this.left = this.right = null;

		}
	}
	static void printLevelOrder(Node root){
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
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
