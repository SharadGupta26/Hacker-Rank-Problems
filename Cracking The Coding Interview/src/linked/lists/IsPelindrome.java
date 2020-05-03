package linked.lists;

public class IsPelindrome {

	public static void main(String[] args) {
		Node head = Node.input(3);
		System.out.println("input : ");
		Node.print(head);
		System.out.println("Output : ");
		System.out.println(isPelindrome(head));
	}
	
	private static boolean isPelindrome(Node head) {
		try {
			isPelindrome(head, head);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static Node isPelindrome(Node head1, Node head2) throws Exception {
		Node n = head2;
		if(n == null) {
			return n;
		}
		n = isPelindrome(head1, head2.next);
		if(head1.data != head2.data) {
			throw new Exception("Not pelindrome");
		} else {
			head1 = head1.next;
		}
		return n;
	}
}
