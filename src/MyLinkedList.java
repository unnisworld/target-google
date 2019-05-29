public class MyLinkedList<T> {

	private Node<T> head;

	/**
	 * Appends a value to the end of the list.
	 * 
	 * @param value
	 */
	public void append(T value) {
		if (head == null) {
			head = new Node<>(value, null);
			return;
		}

		Node<T> node = head;

		while (node.next != null) {
			node = node.next;
		}

		node.next = new Node<>(value, null);
	}

	/**
	 * Returns the element at position. Index starts at 1.
	 * 
	 * @param position
	 * @return
	 */
	public T getElementAt(int position) {

		if (position < 1) {
			return null;
		}

		int counter = 1;
		Node<T> node = head;
		while (node != null && counter < position) {
			node = node.next;
			counter++;
		}

		if (node == null) {
			return null;
		}

		return node.value;
	}

	/**
	 * Inserts a value at position. Index starts at 1.
	 * 
	 * @param value
	 * @param position
	 */
	public void insert(T value, int position) {

		if (head == null) {
			return;
		}

		if (position == 1) {
			head = new Node<T>(value, head);
			return;
		}

		int counter = 1;
		Node<T> node = head;

		while (node != null && counter < position) {
			if (counter == (position - 1)) {
				node.next = new Node<T>(value, node.next);
				return;
			}
			node = node.next;
			counter++;
		}
	}

	/**
	 * Delete the first node with value.
	 * 
	 * @param value
	 */
	public void delete(T value) {

		if (head.value == value) {
			head = head.next;
			return;
		}

		Node<T> node = head;
		Node<T> previousNode = head;
		while (node != null) {
			if (node.value == value) {
				previousNode.next = node.next;
				return;
			}
			previousNode = node;
			node = node.next;
		}
	}

	/**
	 * Print all nodes.
	 */
	public void print() {
		Node<T> node = head;
		System.out.println("");
		while (node != null) {
			System.out.print(node.value + "=>");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList<String> ll = new MyLinkedList<String>();
		ll.append("Unni");
		ll.append("Aparna");
		ll.append("Malavika");
		ll.append("Avantika");

		ll.print();

		System.out.println("\nElement at 1 :" + ll.getElementAt(1));
		System.out.println("Element at 4 :" + ll.getElementAt(4));
		System.out.println("Element at 5 :" + ll.getElementAt(5));
		System.out.println("Element at -1 :" + ll.getElementAt(-1));

		ll.insert("Girija", 1);
		ll.print();
		ll.insert("Valsalan", 2);

		ll.print();

		ll.insert("foo", 1);
		ll.delete("foo");
		ll.delete("Unni");
		ll.delete("bar");

		ll.print();

	}

	class Node<T> {
		private T value;
		private Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

	}
}