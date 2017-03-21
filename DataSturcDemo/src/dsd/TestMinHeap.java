package dsd;

public class TestMinHeap {
	public static void testDemo(){
		MinHeap<Integer> myHeap=new MinHeap<Integer>(Integer.class);
		for(int i:new int[] {47,6,39,88,60,34,23,66,48,85}){
			myHeap.add(i);
		}
		myHeap.printHeap();
		myHeap.add(1);
		myHeap.printHeap();
		myHeap.add(55);
		myHeap.printHeap();
		System.out.println(myHeap.remove());
		System.out.println(myHeap.peek());
		myHeap.printHeap();
	}
}
