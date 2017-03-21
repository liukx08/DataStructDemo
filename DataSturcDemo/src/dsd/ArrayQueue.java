package dsd;

import java.lang.reflect.Array;

public class ArrayQueue<T> {
	private T[] queue;
	
	private int head=0;
	
	private int tail=0;
	
	public ArrayQueue(Class<T> ele){
		@SuppressWarnings("unchecked")
		final T[] tmp=(T[]) Array.newInstance(ele, 3);
		queue=tmp;
	}
	
	public int size(){
		if(this.isEmpty())return 0;
		else if(tail>head)return tail-head;
		else return tail+queue.length-head;
	}
	
	public boolean isEmpty(){
		return head==tail && queue[head]==null;
	}
	
	public void enqueue(T data){
		if(queue[tail]==null){
			queue[tail]=data;
			tail=(tail+1)%queue.length;
		}
		else {
			@SuppressWarnings("unchecked")
			final T[] resizedQ=(T[]) Array.newInstance(queue.getClass().getComponentType(), queue.length+3);
			for(int i=0;i<queue.length;i++){
				resizedQ[i]=queue[head%queue.length];
				head++;
			}
			resizedQ[queue.length]=data;
			tail=queue.length+1;
			queue=resizedQ;
			head=0;
		}
	}
	
	public T dequeue(){
		if(this.isEmpty())return null;
		else {
			T tmp=queue[head];
			queue[head]=null;
			head++;
			return tmp;
		}
	}
	
	public T peek(){
		return queue[head];
	}
}
