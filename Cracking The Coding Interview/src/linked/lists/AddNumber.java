package linked.lists;

public class AddNumber {

	public static void main(String[] args) {
		Node list1 = Node.input(10);
		System.out.println("input 1 : ");
		Node.print(list1);
		System.out.println();
		Node list2 = Node.input(3);
		System.out.println("input 2 : ");
		Node.print(list2);
		System.out.println();
		System.out.println("Result of addition : ");
		Node.print(addNumbers(list1, list2));
	}
	
	private static Node addNumbers(Node head1, Node head2) {
		Node resultHead = null;
		Node tail = null;
		int cf = 0;
		while(head1!= null && head2 != null) {
			int data = head1.data + head2.data + cf;
			cf = data / 10;
			data = data % 10;
			tail = appendNode(tail, data);
			if(resultHead == null) {
				resultHead = tail;
			}			
			head1 = head1.next;
			head2 = head2.next;
		}
		
		while(head1 != null) {
			int data = head1.data + cf;
			cf = data / 10;
			data = data % 10;
			tail = appendNode(tail, data);
			if(resultHead == null) {
				resultHead = tail;
			}
			head1 = head1.next;
		}
		
		while(head2 != null) {
			int data = head2.data + cf;
			cf = data / 10;
			data = data % 10;
			tail = appendNode(tail, data);
			if(resultHead == null) {
				resultHead = tail;
			}
			head2 = head2.next;
		}
		
		if(cf > 0) {
			tail = appendNode(tail, cf);
			if(resultHead == null) {
				resultHead = tail;
			}
		}
		return resultHead;
	}
	
	private static Node appendNode(Node tail, int data) {
		Node n = new Node(data);
		if(tail == null) {
			return n;
		} else {
			tail.next = n;
			tail = n;
			return n;
		}
	}
}
