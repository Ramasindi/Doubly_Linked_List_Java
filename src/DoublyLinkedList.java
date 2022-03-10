import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length; // number of nodes in the dll
	
	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	public  DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	public boolean isEmpty() {
		return length == 0; // head = null
	}
	public int length() {
		return length;
	}
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
		length++; 
	}
	public void insertFist(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			tail = newNode;
		}else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		if(head == tail) {
			tail = null;
		}else {
			head.next.previous = null;
		}
		temp.next = null;
		length--;
		
		
		return temp;
	}
	public ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = tail;
		if(head == tail) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		return temp;
	}
	public void displayforward() {
		if(head == null) {return;}
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -->");
			temp = temp.next;
		}System.out.println("null");
		
	}
	public void displayBackwards() {
		if(tail == null) {return;}
		ListNode temp = tail;
		while(temp != null) {
			System.out.print(temp.data + " -->");
			temp = temp.previous;
		}System.out.println("null");
	}
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertFist(1);
		dll.insertFist(10);
		dll.insertFist(20);
		dll.insertLast(6);
		// traverse forward
		dll.displayforward();
		// traverse backward
		dll.displayBackwards();
	}
}
