package linked.lists;

public class TestSingleLinkedList {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		list.addLast(5);
		list.addLast(6);
		list.addFirst(0);
		list.addLast(4);
		list.addFirst(1);
		list.addFirst(2);
		
		
		
		
		System.out.println("List size is " + list.size());
		
		list.print();
	}
}
