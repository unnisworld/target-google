import java.util.NoSuchElementException;

public class QueueBackedByArray<E> {

	private E[] elements;
	
	private int top;
	private int rear;
	private int n;
	
	public QueueBackedByArray(int size) {
		elements = (E[])new Object[size];
	}
	
	public void enqueue(E item) {
		if (n == elements.length) {
			resize(n * 2);
		}
		elements[rear++] = item;
		n++;
		
		if (rear == elements.length) {
			rear = 0;
		}
	}
	
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		n--;
		E item = elements[top++];
		
		if (top == elements.length) {
			top = 0;
		}
		
		if (n > 0 && n == elements.length/4) {
			resize(elements.length/2);
		}
		
		return item;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	private void resize(int newSize) {
		E[] tmp = (E[])new Object[newSize];
		
		for(int i=0;i<n;i++) {
			tmp[i] = elements[top];
			top++;
			
			if (top == elements.length) {
				top = 0;
			}
		}
		
		elements = tmp;
		top = 0;
		rear = n;
	}
	
	public static void main(String[] args) {
		QueueBackedByArray<String> queue = new QueueBackedByArray<String>(2);
		
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		System.out.println(queue.dequeue());
	}
}
