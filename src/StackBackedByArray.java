import java.util.Iterator;

public class StackBackedByArray<E> implements Iterable<E> {

	private E[] elements;
	private int N;
	
	public StackBackedByArray(int n) {
		elements = (E[])new Object[n];
	}
	
	public void push(E item) {
		if (N == elements.length) {
			resize(elements.length * 2);
		}
		elements[N++] = item;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		
		E item = elements[--N];
		
		if (N > 0 && N == elements.length/4) {
			resize(elements.length/4);
		}
		
		return item;
	}
	
	private void resize(int size) {
		E[] tmp = (E[])new Object[size];
		
		for (int i=0;i<N;i++) {
			tmp[i] = elements[i];
		}
		
		elements = tmp;
	}
	
	public static void main(String[] args) {
		StackBackedByArray<String> stack = new StackBackedByArray<String>(2);
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		for(String item : stack) {
			System.out.println(item);
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}
	
	class ReverseArrayIterator implements Iterator<E> {
		
		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public E next() {
			return elements[--i];
		}
		
	}
	
	
}
