import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackBackedByLinkedList<E> implements Iterable<E> {
	
	private Node<E> top;
	private int n;
	
	public StackBackedByLinkedList() {
		top = null;
		n = 0;
	}
	
	public void push(E item) {
		Node<E> newNode = new Node<E>();
		newNode.item = item;
		newNode.next = top;
		top = newNode;
		n++;
	}
	
	public E pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack is empty.");
		
		E item = top.item;
		top = top.next;
		return item;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	private static class Node<E> {
		private E item;
		private Node<E> next;
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator<E>(top);
	}
	
	private class StackIterator<E> implements Iterator<E>{
		
		private Node<E> currentNode;
		
		StackIterator(Node<E> top) {
			currentNode = top;
		}
		
		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No such element.");
			}
			E item = currentNode.item;
			currentNode = currentNode.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		StackBackedByLinkedList<String> stack = new StackBackedByLinkedList<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		for(String item : stack) {
			System.out.println(item);
		}
	}
}
