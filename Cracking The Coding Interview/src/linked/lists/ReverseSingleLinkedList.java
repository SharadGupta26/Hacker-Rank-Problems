package linked.lists;

public class ReverseSingleLinkedList {

	public static void main(String[] args) {
		Node input = Node.input(10);
		System.out.println("Input : ");
		Node.print(input);
		
		Node head = input;
		System.out.println();
		System.out.println("reversed list (using loop) : ");
		
		Node.print(reverse_2(head));
		
		System.out.println();
		System.out.println("reversed list (using recursion) : ");
		head = input;
		Node.print(reverse_1(head));
		
		/*System.out.println();
		System.out.println("Reversed list using recursion method 2");
		print(reverse_3(input, null));
		*/

	}

	/*private static void print(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			System.out.print(' ');
			n = n.next;
		}
	}
*/
	/*private static Node input() {
		Node head = null;
		Node temp = head;
		Random r = new Random();
		int n = 10;
		while (n-- > 0) {
			Node node = new Node(r.nextInt(10));
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
*/
	private static Node reverse_1(Node a) {
		Node head = a;
		if (a.next == null) {
			return head;
		}
		head = reverse_1(a.next);
		a.next.next = a;
		a.next = null;
		return head;
	}
	
	private static Node reverse_2(Node a) {
		Node prev = null;
		Node next = null;
		Node curr = a;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;		
	}
	
	/*private static Node reverse_3(Node curr, Node prev) {
		Node head = curr;
		if(curr.next == null) {
			curr.next = prev;
			return head;
		}
		
		curr = curr.next;
		curr.next = prev;
		head = reverse_3(curr, curr);
		return head;
	}*/
}
