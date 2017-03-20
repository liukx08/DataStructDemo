package dsd;

public class TestMyLinkedList {
	public static void testDemo(){
		MyLinkedList<Integer> myList=new MyLinkedList<Integer>();
		for(int i=0;i<10;i++){
			myList.addLast(i);
		}
		myList.printList();
//		myList.addFirst(666);
//		myList.addLast(888);
		myList.printList();
		System.out.println(myList.getFirst());
		System.out.println(myList.getLast());
		System.out.println(myList.get(3));
		myList.remove(5);
		myList.printList();
		System.out.println(myList.size());
		myList.reverseLinkedList2();
		myList.printList();
	}
}