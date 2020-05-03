package linked.lists;

import java.util.Random;

public class Node {

	public Integer data;
	
	public Node next;
	
	public Node(Integer data) {
		this.data = data;
	}
	
	public static Node input(int length) {
		Node head = null;
		Node temp = head;
		Random r = new Random();
		int n = length;
		while (n-- > 0) {
			Node node = new Node(r.nextInt(length));
			if (head == null) {
				head = node;
				temp = head;
			} else {
				temp.next = node;
				temp = node;
			}
		}
		return head;
	}
	
	public static void print(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			System.out.print(' ');
			n = n.next;
		}
		System.out.println();
	}

}
