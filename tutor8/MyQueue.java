import java.util.LinkedList;

class MyQueue<E> extends LinkedList<E> {
	public MyQueue() {
		super();
	}

	public void enqueue(E element) {
		this.addLast(element);
	}

	public E dequeue() {
		return this.poll();
	}
}