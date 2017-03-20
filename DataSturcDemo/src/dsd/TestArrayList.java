package dsd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestArrayList {
	public static void printArray(ArrayList<Integer> lis){
		for(int i=0;i<lis.size();i++){
			System.out.print(lis.get(i)+" ");
		}
		System.out.println("");
	}
	
	public static void testDemo(){
		ArrayList<Integer> arr1=new ArrayList<Integer>();
		ArrayList<Integer> arr2=new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			arr1.add(i);
			arr2.add(i+5);
		}
		printArray(arr1);
		arr1.addAll(arr2);
		printArray(arr1);
		arr1.add(100);
		arr1.add(0, 100);
		printArray(arr1);
		arr1.set(0, 88);
		arr1.remove(11);
		printArray(arr1);
		System.out.print(arr1.contains(88));
		System.out.println("");
		Iterator<Integer> it=arr1.iterator();
		while(it.hasNext()){
			if(it.next()%2==0)it.remove();
		}
		printArray(arr1);
		ListIterator<Integer> listit=arr1.listIterator();
		while(listit.hasNext()){
			if(listit.next()==3){
				listit.add(666);
				System.out.print(listit.next());	// when next() is called, the reference move to next element
				System.out.println("");
				break;
			}
		}
		printArray(arr1);
	}
}
