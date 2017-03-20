package dsd;

public class TestArray {
	int[] arr;
	
	TestArray(int[] arr){
		this.arr=arr;
	}
	
	public void printArr(){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		return;
	}
	
	public void printArrk(int k){			// locate k th element
			System.out.println(arr[k]);
		return;
	}
	
	public void insertEle(int newEle, int k){			// insert newEle at k th entry
		if(0<=k && k<this.arr.length){
			int[] inserted=new int[this.arr.length+1];
			for(int i=0;i<k;i++)inserted[i]=this.arr[i];
			inserted[k]=newEle;
			for(int i=k+1;i<=this.arr.length;i++)inserted[i]=this.arr[i-1];
			this.arr=inserted;
		}
	}
	
	class NameCard{							// local class for compareCopy test
		String name;
		
		NameCard(String name){
			this.name=name;
		}
		
		NameCard copyOf(){
			NameCard copyCard=new NameCard(this.name);
			return copyCard;
		}
	}
	
	public void compareCopy(){
		NameCard[] name1=new NameCard[1];
		NameCard[] name2=new NameCard[1];
		name1[0]=new NameCard("Bit");
		name2[0]=name1[0];
		name1[0].name="Tiger";					// shallow copy
		System.out.println(name1[0].name);
		System.out.println(name2[0].name);
		name2[0]=name1[0].copyOf();				// deep copy
		name1[0].name="Bittiger";
		System.out.println(name1[0].name);
		System.out.println(name2[0].name);		
	}
}
