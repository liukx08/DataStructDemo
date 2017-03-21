package dsd;

import java.lang.reflect.Array;

public class MinHeap<T extends Comparable<T>> {
	private T[] arr;
	private int size;
	
	public MinHeap(Class<T> ele){
		@SuppressWarnings("unchecked")
		final T[] tmp=(T[]) Array.newInstance(ele,65);
		arr=tmp;
		size=0;
	}
	
	public void add(T data){
		if(size==arr.length-1){
			@SuppressWarnings("unchecked")
			final T[] tmp=(T[]) Array.newInstance(arr.getClass().getComponentType(),2*arr.length-1);
			for(int i=1;i<=size;i++){
				tmp[i]=arr[i];
			}
			arr=tmp;
		}
		size++;
		arr[size]=data;
		bubbleup();
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public T peek(){
		if(isEmpty())return null;
		else return arr[1];
	}
	
	public T remove(){
		if(isEmpty())return null;
		else {
			swap(1,size);
			T tmp=arr[size];
			arr[size]=null;
			size--;
			bubbledown();
			return tmp;
		}
	}
	
	public void printHeap(){
		for(int i=1;i<=size;i++)System.out.print(arr[i]+" ");
		System.out.println("");
	}
	
	private void bubbledown(){
		int index=1;
		while(2*index<=size){
			int small=2*index;
			if(2*index+1<=size)
				if(arr[2*index].compareTo(arr[2*index+1])>0)
					small=2*index+1;
			if(arr[index].compareTo(arr[small])<0)break;
			else swap(index,small);
			index=small;
		}
	}
	
	private void bubbleup(){
		int index=size;
		while(index>1){
			if(arr[index/2].compareTo(arr[index])<0)break;
			else swap(index/2,index);
			index=index/2;
		}
	}
	
	private void swap(int index1, int index2){
		T tmp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=tmp;
	}
}
