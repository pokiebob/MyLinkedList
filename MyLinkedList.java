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
		if (size == 0) {
			start = new Node(value);
		}
		return true;
	}


	public void add(int index, String value) {

	}

	public String get(int index) {
		return "some value";
	}

	public String set(int index, String value) {
		return "some value";
	}

	public String toString() {
		return "toString";
	}
	//Any helper method that returns a Node object MUST BE PRIVATE!

	public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();

		System.out.println(ll.size());



	}
}