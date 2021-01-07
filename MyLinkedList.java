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
		} else if (index == size) {
			end.setNext(newNode);
			newNode.setPrev(end);
			end = newNode;
		} else {
			Node curNode = start;

			for (int i = 1; i < index; i++) {
				curNode = curNode.getNext();
			}
			newNode.setPrev(curNode);
			if (index < size) {
				newNode.setNext(curNode.getNext());
				curNode.getNext().setPrev(newNode);
			}
			curNode.setNext(newNode);
		}
		size++;
	}

	public String get(int index) {
		Node curNode = start;
		for (int i = 1; i <= index; i++) {
			curNode = curNode.getNext();
		}
		return curNode.getValue();
	}

	public String set(int index, String value) {
		return "some value";
	}

	public String toString() {
		String s = "[";
		Node curNode = start;
		for (int i = 0; i < size - 1; i++) {
			s += curNode.getValue() + ", ";
			curNode = curNode.getNext();
		}
		s += curNode.getValue() + "]";
		return s;
	}
	//Any helper method that returns a Node object MUST BE PRIVATE!

	public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();

		System.out.println(ll.size());

		ll.add("a");
		ll.add("b");
		ll.add("c");
		System.out.println(ll);

		ll.add(1, "d");
		System.out.println(ll);
		ll.add(0, "e");
		System.out.println(ll);
		ll.add(5, "f");
		System.out.println(ll);


	}
}