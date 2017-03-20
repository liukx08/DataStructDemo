package dsd;

import java.util.LinkedList;

public class LLStack<T> {

	private LinkedList<T> stack;
	
	public LLStack(){
		stack=new LinkedList<T>();
	}
	
	public void push(T data){
		stack.addFirst(data);
	}
	
	public T pop(){
		T tmp=stack.getFirst();
		stack.removeFirst();
		return tmp;
	}
	
	public T peek(){
		return stack.getFirst();
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
}
