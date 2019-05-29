import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueBackedByLinkedList<E> implements Iterable<E> {
	
	private Node<E> head;
	private Node<E> tail;
	
	public void enqueue(E item) {
		Node<E> newNode = new Node<E>();
		newNode.item = item;
		
		if (isEmpty()) {
			tail = newNode;
			head = newNode;
		} 
		else {	
			tail.next = newNode;
			tail = newNode;
		}	
	}
	
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		
		Node<E> node = head;
		head = head.next;
		
		return node.item;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	private static class Node<E> {
		private E item;
		private Node<E> next;
	}
	
	public static void main(String[] args) {
		QueueBackedByLinkedList<String> queue = new QueueBackedByLinkedList<String>();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		//System.out.println(queue.dequeue());
		
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");

		for(String item : queue) {
			System.out.println(item);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator(head);
	}
	
	private class QueueIterator<E> implements Iterator<E> {
		
		private Node<E> head;
		
		QueueIterator(Node<E> head) {
			this.head = head;
		}
		
		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public E next() {
			E item = head.item;
			head = head.next;
			return item;
		}
		
	}
}
