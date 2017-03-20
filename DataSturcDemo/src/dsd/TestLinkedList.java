package dsd;

//import java.util.ListIterator;
import java.util.LinkedList;

public class TestLinkedList {
	public static void testDemo(){
		LinkedList<Integer> myList=new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			myList.addLast(i);
		}
		System.out.println(myList);
		myList.addFirst(666);
		myList.addLast(888);
		System.out.println(myList);
		System.out.println(myList.getFirst());
		System.out.println(myList.getLast());
		System.out.println(myList.get(3));
		myList.remove(5);
		System.out.println(myList);
//		ListIterator<Integer> listit=myList.listIterator();
		}	
}
