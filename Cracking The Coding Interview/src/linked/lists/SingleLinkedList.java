package linked.lists;

public class SingleLinkedList {
 
	private Node head = new Node(null);
	
	private Node tail = head;
	
	private int size;
	
	/** Node is added at the end of list
	 * Returns the new Node added
	 * @param data
	 * @return
	 */
	public Node addLast(int data) {
		Node n = new Node(data);
		tail.next = n;
		tail = n;
		size++;
		return n;		
	}
	
	/**
	 * Node is added at start of list
	 * Returns the new node added
	 * @param data
	 * @return
	 */
	public Node addFirst(int data) {
		Node n = new Node(data);
		n.next = head.next;
		head.next = n;
		size++;
		
		if(size == 1) {
			tail = n;
		}
		return n;
	}
	
	public void print() {
		Node tail = head.next;
		while(tail != null) {
			System.out.println(tail.data);
			tail = tail.next;
		}
	}
	
	public int size() {
		return size;
	}
}
