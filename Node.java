public class Node {

	private String data;
	private Node next, prev;

	public Node(String value) {
		data = value;
		prev = null;
		next = null;
	}

	public String getValue() {
		return data;
	}

	public void setValue(String newValue) {
		data = newValue;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node newNext) {
		next = newNext;

	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node newPrev) {
		prev = newPrev;
	}


}