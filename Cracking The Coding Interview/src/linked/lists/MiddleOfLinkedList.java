package linked.lists;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		Node head = Node.input(10);
		System.out.println("Input : ");
		Node.print(head);
		System.out.println("Middle node is : ");
		System.out.println(getMiddle(head).data);
		System.out.println(getMiddle_2(head).data);
		
	}
	
	/**
	 * Fast pointer approach
	 * @param head
	 * @return
	 */
	private static Node getMiddle(Node head) {
		Node p1 = head;
		Node p2 = head;
		
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;					
		}
		return p1;
	}
	
	/**
	 * Traverse half the list
	 * increment counter while traversing the nodes. Move pointer when counter is odd
	 */
	private static Node getMiddle_2(Node head) {
		Node p1 = head;
		int count = 0;
		while(head != null) {
			count ++;
			head = head.next;
			if((count & 1) == 0) {
				p1 = p1.next;
			}
		}
		return p1;
	}
}
