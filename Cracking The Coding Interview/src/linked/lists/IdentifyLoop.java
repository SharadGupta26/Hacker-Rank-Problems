package linked.lists;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdentifyLoop {

	public static void main(String[] args) {
		Node head = createCorruptList();
		System.out.println(identifyLoop(head).data);
		System.out.println(identifyLoop_2(head).data);
		System.out.println(standardSolution(head).data);
		//Node.print(head);
	}
	
	private static Node createCorruptList() {
		int n = 10;
		int count = n;
		Node head = null;
		Node tail = null;
		Random r = new Random();
		while(count-- > 0) {
			Node p = new Node(r.nextInt());
			if(head == null) {
				head = p;
			}
			
			if(tail == null) {
				tail = p;
			} else {
				tail.next = p;
				tail = p;
			}				
		}
		
		int i1 = r.nextInt(n);
		int i2 = r.nextInt(n);
		boolean b = false;
		if(i1 > i2) {
			b = true;
		} else {
			b = false;
		}
				
		System.out.println("Corrupting " + i1 + " and " + i2) ;
		Node p1 = head;
		Node p2 = head;
		while(i1-- > 0) {
			p1 = p1.next;
		}
		while(i2-- > 0) {
			p2 = p2.next;
		}
		if(b) {
			System.out.println("Currupting node -> " + p2.data);
			System.out.println(p1.data);
			p1.next = p2;
		} else {
			System.out.println("Currupting node -> " + p1.data);
			System.out.println(p2.data);
			p2.next = p1;
		}
		return head;
	}
	
	private static Node identifyLoop(Node head) {
		Set<Node> set = new HashSet<>();
		Node p = head;
		while(p != null) {
			if(set.contains(p.next)) {
				return p.next;
			} else {
				set.add(p);
				 p = p.next;
			}
		}
		return null;
	}
	
	private static Node identifyLoop_2(Node head) {
		Node prev = head;
		Node n = head.next;
		while( n != null ) {
			boolean b = itFormsLoop(head, prev, n);
			if(b) {
				return n;
			} else {
				prev = n;
				n = n.next;
			}
		}
		return null;
	}
	
	private static boolean itFormsLoop(Node head, Node prev, Node n) {
		while(head != prev) {
			if(head == n) {
				return true;
			} else {
				head = head.next;
			}
		}
		return false;
	}
	
	/**
	 * It works on ideology that if p2 runs fast as twice as p1. then they will cross paths exactly once.
	 * To get node at start of loop, we 
	 * @param head
	 * @return
	 */
	private static Node standardSolution(Node head) {
		Node p1 = head;
		Node p2 = head;
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p1 == p2) {
				break;
			}
		}
		
		if(p1 != p2) {
			return null;
		}
		
		p1 = head;
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
		
	}
}
