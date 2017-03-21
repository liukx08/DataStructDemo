package dsd;

import java.util.Iterator;

public class TestBST {
	public static void testDemo(){
		BST mytree=new BST();
		mytree.insert(10);
		mytree.insert(5);
		mytree.insert(3);
		mytree.insert(7);
		mytree.insert(20);
		mytree.insert(15);
		mytree.insert(21);
		mytree.printBST();
		mytree.delete(10);
		mytree.printBST();
		Iterator<Integer> it=mytree.iterator();
		while(it.hasNext())System.out.print(it.next()+" ");
	}
}
