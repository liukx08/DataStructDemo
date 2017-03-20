package dsd;

public class MyLinkedList<T> {
	private static class Node<T> {		//do not have access to other members of the enclosing class
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	
	public MyLinkedList(){
		head=null;
	}
	
	public void printList(){
		Node<T> tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
		System.out.println("");
	}
	
	public void addFirst(T data){
		Node<T> tmp=new Node<T>(data,head);
		head=tmp;
	}
	
	public void addLast(T data){
		if(isEmpty())head=new Node<T>(data,null);
		else{
			Node<T> tmp=head;
			while(tmp.next!=null){
				tmp=tmp.next;
			}
			tmp.next=new Node<T>(data,null);
		}
	}
	
	public T getFirst(){
		if(isEmpty())return null;
		return head.data;
	}
	
	public T getLast(){
		if(isEmpty())return null;
		else{
			Node<T> tmp=head;
			while(tmp.next!=null){
				tmp=tmp.next;
			}
			return tmp.data;
		}
	}
	
	public T get(int index){
		if(index>=0 && index<size()){
			Node<T> tmp=head;
			for(int i=0;i<index;i++)tmp=tmp.next;
			return tmp.data;
		}
		else return null;
	}
	
	public int get(T data){
		if(head==null)return -1;
		else {
			int index=0;
			Node<T> tmp=head;
			while((!tmp.data.equals(data))&&(tmp.next!=null)){
				tmp=tmp.next;
				index++;
			}
			if(tmp.data.equals(data))return index;
			else return -1;
		}
	}
	
	public boolean remove(int index){
		if(isEmpty())return false;
		else if(index==0){
			head=head.next;
			return true;
		}
		else if(index>0 && index<size()){
			Node<T> tmp=head;
			for(int i=0;i<index-1;i++)tmp=tmp.next;
			tmp.next=tmp.next.next;
			return true;
		}
		else return false;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int size(){
		int size=0;
		Node<T> tmp=head;
		while(tmp!=null){
			size++;
			tmp=tmp.next;
		}
		return size;
	}
	
	public boolean insertBefore(T key, T toInsert){
		if(isEmpty())return false;
		else {
			Node<T> tmp=head;
			if(tmp.data.equals(key)){
				addFirst(toInsert);
				return true;
			}
			else {
				while((!tmp.next.data.equals(key))&&(tmp.next!=null))tmp=tmp.next;
				if(tmp.next==null)return false;
				else {
					tmp.next=new Node<T>(toInsert,tmp.next);
					return true;
				}
			}
		}
	}
	
	public boolean insertAfter(T key, T toInsert){
		if(isEmpty())return false;
		else {
			Node<T> tmp=head;
			while((!tmp.data.equals(key))&&(tmp.next!=null)){
				tmp=tmp.next;
			}
			if(tmp.data.equals(key)){
				tmp.next=new Node<T>(toInsert,tmp.next);
				return true;
			}
			else return false;
		}	
	}
	
	public void reverseLinkedList1(){
		if(isEmpty()||head.next==null)return;
		else {
			Node<T> prev=head;
			Node<T> next=head;
			head=head.next;
			next=head.next;
			prev.next=null;
			while(next!=null){
				head.next=prev;
				prev=head;
				head=next;
				next=head.next;
			}
			head.next=prev;
			return;
		}	
	}
	
	public void reverseLinkedList2(){
		if(isEmpty()||head.next==null)return;
		else {
			Node<T> headCopy=head;
			head=head.next;
			Node<T> tail=head;
			headCopy.next=null;
			reverseLinkedList2();
			tail.next=headCopy;
			return;
		}	
	}
}
