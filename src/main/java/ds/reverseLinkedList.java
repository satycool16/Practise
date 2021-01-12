package main.java.ds;

public class reverseLinkedList {
	static class LinkedList{
		Node head;
		LinkedList(){
			this.head = null;
		}
		LinkedList(int data){
			this.head = new Node(data);
		}
		private void printList(Node head){
			while (head!=null){
				System.out.print(head.data + " ");
				head = head.next;
			}
		}
	}
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	static Node reverseALinkedList(Node head){
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next.next.next = new Node(8);

		System.out.println("Original Linked list ");
		list.printList(list.head);
		Node res = reverseALinkedList(list.head);
		System.out.println("");
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(res);
	}
}
