public class MyLinkedList {

	private int size;
	private Node start,end;  


	public MyLinkedList() {
		size = 0;
		start = null;
		end = null;
	}

	public int size() {
		return size;
	}

	public boolean add(String value) {
		Node newNode = new Node(value);
		if (size == 0) {
			start = newNode;
			end = newNode;
			size++;
			return true;
		}

		end.setNext(newNode);
		newNode.setPrev(end);
		end = newNode;
		size++;
		return true;
	}


	public void add(int index, String value) {
		Node newNode = new Node(value);



		if (index == 0) {
			newNode.setNext(start);
			start.setPrev(newNode);
			start = newNode;
		}
		Node curNode = start;

		for (int i = 0; i < index; i++) {
			curNode = curNode.getNext();
		}
		newNode.setPrev(curNode);
		if (index < size) {
			newNode.setNext(curNode.getNext());
			curNode.getNext().setPrev(newNode);
		}
		curNode.setNext(newNode);
		size++;
	}

	public String get(int index) {
		return "some value";
	}

	public String set(int index, String value) {
		return "some value";
	}

	public String toString() {
		String s = "[";
		return "toString";
	}
	//Any helper method that returns a Node object MUST BE PRIVATE!

	public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();

		System.out.println(ll.size());

		ll.add("a");
		ll.add("b");
		ll.add("c");
		System.out.println(ll.size());

		ll.add(1, "d");
		ll.add(0, "e");
		ll.add(5, "f");
		System.out.println(ll.size());


	}
}