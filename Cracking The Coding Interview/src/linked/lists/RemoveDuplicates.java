package linked.lists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
	public static void main(String[] args) {

		Node head = Node.input(15);
		System.out.println("input : ");
		Node.print(head);
		System.out.println("output : ");
		Node.print(removeDuplicates(head));

		System.out.println();
		System.out.println("approach 2 : ");
		Node.print(removeDuplicates_2(head));
		
		System.out.println();
		System.out.println("approach 3 : ");
		Node.print(removeDuplicates_3(head));

	}

	private static Node removeDuplicates(Node head) {
		Node newHead = new Node(head.data);
		Node n = head.next;
		// Node tail = newHead;
		while (n != null) {
			int data = n.data;
			appendIfNotExists(newHead, data);
			n = n.next;
		}
		return newHead;
	}

	/**
	 * not using buffer, but creating new linked list of unique elements by checking
	 * current element with all previous elements.
	 * 
	 * @param head
	 * @param data
	 */
	private static void appendIfNotExists(Node head, int data) {
		boolean exists = false;
		// Node n = head;
		Node tail = head;
		while (head != null) {
			if (head.data == data) {
				exists = true;
				break;
			}
			if (head.next == null) {
				tail = head;
			}
			head = head.next;
		}
		if (exists == false) {
			Node node = new Node(data);
			tail.next = node;
			// head = node;
		}
	}

	/**
	 * Not using buffer, but modifying original linked list. Deleting node that is
	 * duplicate by checking current element with all previous elements
	 * 
	 * @param head
	 * @return
	 */
	private static Node removeDuplicates_2(Node head) {
		Node prev = head;
		Node n = head.next;
		while (n != null) {
			boolean exists = checkIfExists(head, n, n.data);
			if (exists) {
				prev.next = n.next;
				n = n.next;
			} else {
				prev = n;
				n = n.next;
			}
		}
		return head;
	}

	private static boolean checkIfExists(Node head, Node tail, int data) {
		if (head == null) {
			return false;
		}
		while (head != tail) {
			if (head.data == data) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	/**
	 * It uses extra buffer to keep track of duplicate elements. If current element
	 * exists in buffer, we skip current node else we move forward.
	 * 
	 * @param head
	 * @return
	 */
	private static Node removeDuplicates_3(Node head) {
		Map<Integer, Object> map = new HashMap<>();
		Node n = head;
		Node prev = head;
		while (n != null) {
			if (map.containsKey(n.data)) {
				prev.next = n.next;
			} else {
				map.put(n.data, null);
				prev = n;
			}
			n = n.next;
		}
		return head;
	}

}
