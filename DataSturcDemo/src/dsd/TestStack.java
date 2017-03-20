package dsd;

//import java.util.Stack;

public class TestStack {
	public static void testDemo(){
		ArrayStack<Integer> myStack=new ArrayStack<Integer>(Integer.class, 100);
		for(int i=0;i<2;i++){
			myStack.push(i);
		}
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		System.out.println(myStack.isEmpty());
		myStack.peek();
	}
}
