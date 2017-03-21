package dsd;

import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> queue;
	
	public Queue(){
		queue = new LinkedList<T>();
	}
	
	public void enqueue(T data){
		queue.add(data);			// offer()
	}
	
	public T dequeue(){
		return queue.poll();
	}
	
	public T peek(){				// element()
		return queue.peek();
	}
	
	public int size(){
		return queue.size();
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
}
