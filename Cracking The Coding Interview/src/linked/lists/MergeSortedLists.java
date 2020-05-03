package linked.lists;

import java.util.Arrays;
import java.util.Random;

public class MergeSortedLists {

	public static void main(String[] args) {
		Node head1 = generateSortedList(10);
		Node head2 = generateSortedList(10);
		System.out.println("input : ");
		Node.print(head1);
		Node.print(head2);
		System.out.println("Output : ");
		//Node.print(merge(head1, head2));
		Node.print(merge_2(head1, head2));
	}

	private static Node generateSortedList(int n) {
		int[] arr = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(n);
		}
		Arrays.sort(arr);
		Node head = null;
		Node tail = null;
		for (int i = 0; i < n; i++) {
			Node p = new Node(arr[i]);
			if (head == null) {
				head = p;
				tail = p;
			} else {
				tail.next = p;
				tail = p;
			}
		}
		return head;
	}

	private static Node merge(Node head1, Node head2) {
		Node prev = null;
		Node p1 = head1;
		Node p2 = head2;
		while (p1 != null && p2 != null) {
			if (p2.data < p1.data) {
				Node temp = p2.next;
				p2.next = p1;
				if (prev != null) {
					prev.next = p2;
				} else {
					head1 = p2;
				}
				prev = p2;
				p2 = temp;
			} else {
				prev = p1;
				p1 = p1.next;
			}
		}

		if (p2 != null) {
			prev.next = p2;
		}

		return head1;
	}
	
	private static Node merge_2(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			return null;
		}
		
		if(head1 == null) {
			return head2;
		}
		
		if(head2 == null) {
			return head1;
		}
		
		Node c = null;
		if(head1.data < head2.data) {
			c = head1;
			c.next = merge_2(head1.next, head2);
		} else {
			c = head2;
			c.next = merge_2(head1, head2.next);
		}
		return c;
	}
}
