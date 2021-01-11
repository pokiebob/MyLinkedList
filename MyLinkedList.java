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
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index" + index + "not within range");
		}
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
			newNode.setNext(curNode.getNext());
			curNode.getNext().setPrev(newNode);
			curNode.setNext(newNode);
		}
		size++;
	}

	public String remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index" + index + "not within range");
		}
		Node curNode;

		if (index == 0) {
			curNode = start;
			start = start.getNext();
			start.setPrev(null);
		} else if (index == size - 1) {
			curNode = end;
			end = end.getPrev();
			end.setNext(null);
		} else {
			curNode = start;

			for (int i = 1; i < index; i++) {
				curNode = curNode.getNext();
			}
			curNode.setNext(curNode.getNext().getNext());
			
			curNode.getNext().setPrev(curNode);
		}
		size--;
		return curNode.getValue();

	}

	public String get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index" + index + "not within range");
		}
		Node curNode = start;
		for (int i = 1; i <= index; i++) {
			curNode = curNode.getNext();
		}
		return curNode.getValue();
	}

	public String set(int index, String value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index" + index + "not within range");
		}
		Node curNode = start;
		for (int i = 1; i <= index; i++) {
			curNode = curNode.getNext();
		}
		String prevValue = curNode.getValue();
		curNode.setValue(value);
		return prevValue;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String s = "[";
		Node curNode = start;
		for (int i = 0; i < size - 1; i++) {
			s += curNode.getValue() + ", ";
			curNode = curNode.getNext();
		}
		s += curNode.getValue() + "]";
		return s;
	}

	public String toStringReversed() {
		if (size == 0) {
			return "[]";
		}
		String s = "[";
		Node curNode = end;
		for (int i = 0; i < size - 1; i++) {
			s += curNode.getValue() + ", ";
			curNode = curNode.getPrev();
		}
		s += curNode.getValue() + "]";
		return s;
	}

	public void extend(MyLinkedList other) {
		end.setNext(other.start);
		other.start.setPrev(end);
		end = other.end;
		size += other.size();
		other.clear();
 	}

 	public void clear() {
 		size = 0;
 		start = null;
 		end = null;
 	}

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
		System.out.println(ll.set(3, "g"));
		System.out.println(ll);

		ll.remove(0);
		System.out.println(ll);
		ll.remove(4);
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);

		MyLinkedList a = new MyLinkedList();
		MyLinkedList b = new MyLinkedList();
		for(int i = 0; i < 10; i++){
		  if(i < 5){
		    a.add(i+"");
		  }else{
		    b.add(i+"");
		  }
		}
		System.out.println();
		System.out.println("A:"+a+a.size());
		System.out.println("B:"+b+b.size());

		a.extend(b);
		System.out.println("A:"+a+a.size());
		System.out.println("B:"+b+b.size());
		System.out.println("A reversed:"+a.toStringReversed()+a.size());
		System.out.println("B reversed:"+b.toStringReversed()+b.size());


	}
}