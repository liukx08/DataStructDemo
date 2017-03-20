package dsd;

import java.lang.reflect.Array;

public class ArrayStack<T> {

	private T[] arr;
	
	private int size;
	
	private int top;
	
	public ArrayStack(Class<T> ele, int size){
		@SuppressWarnings("unchecked")
		final T[] arr=(T[]) Array.newInstance(ele, size);
		this.arr=arr;
		this.size=size;
		top=-1;
	}
	
	public void push(T data) throws ArrayIndexOutOfBoundsException{
		if(top==arr.length-1)throw new ArrayIndexOutOfBoundsException("Stack is full!");
		else {
			arr[++top]=data;
		}
	}
	
	public T pop() throws ArrayIndexOutOfBoundsException{
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty!");
		else {
			T tmp=arr[top--];
			arr[top+1]=null;
			return tmp;
		}
	}
	
	public T peek() throws ArrayIndexOutOfBoundsException{
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty!");
		else{
			return arr[top];
		}
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public int size(){
		return size;
	}
}
