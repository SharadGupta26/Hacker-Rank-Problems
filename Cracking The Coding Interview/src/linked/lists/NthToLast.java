package linked.lists;

/**
 * Given n and head to a single linked list, print n elements from last
 * @author Sharad Gupta
 *
 */
public class NthToLast {

	public static void main(String[] args) {
		Node head = Node.input(10);
		int n = 10;
		System.out.println("Input : ");
		Node.print(head);
		System.out.println("Expected o/p : ");
		Node.print(nthToLast(head, n));
		
		System.out.println("My implementation : ");
		Node.print(nthToLast_2(head, n));
		
		
	}
	
	private static Node nthToLast(Node head, int n) {
		Node p1 = head;
		Node p2 = head;
		for(int i = 0 ; i< n -1 ; i++) {
			if(p2 == null || p2.next == null)  {
				//size less than n
				return null;
			}
			p2 = p2.next;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	private static Node nthToLast_2(Node head, int n) {
		int size = 0;
		Node p = head;
		while(p != null) {
			size++;
			p = p.next;
		}
		
		if(size < n) {
			//size less than n
			return null;
		}
		
		int count = size - n;
		p = head;
		while(count-- > 0) {
			p = p.next;
		}
		return p;
	}
}
