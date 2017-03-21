package dsd;

public class TestQueue {
	public static void testDemo(){
		ArrayQueue<String> myQueue=new ArrayQueue<String>(String.class);
		myQueue.enqueue("Tom");
		myQueue.enqueue("Jeff");
		myQueue.enqueue("Qingyuan");
		myQueue.enqueue("Ramesh");
		myQueue.enqueue("Nakamura");
		System.out.println(myQueue.size());
		System.out.println(myQueue.peek());
		System.out.println(myQueue.size());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.isEmpty());
		System.out.println(myQueue.size());
		while(!myQueue.isEmpty()){
			System.out.println(myQueue.dequeue());
		}
		System.out.println(myQueue.isEmpty());
		System.out.println(myQueue.peek());
	}	
}
