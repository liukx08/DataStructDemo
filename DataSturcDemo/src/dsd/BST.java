package dsd;

import java.util.Iterator;
import java.util.Stack;

public class BST implements Iterable<Integer>{
	private static class Node{
		int key;
		Node left,right;
		
		Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	
	private Node root;
	
	public BST(){
		root=null;
	}
		
	public void printBST(){						// print a BST level by level, assume no key equals 0, 0 represents null
		Queue<Node> BFS=new Queue<Node>();		
		BFS.enqueue(root);
		while(BFS.size()!=0){
			Node curr=BFS.dequeue();
			if(curr==null)System.out.print("0"+" ");
			else {
				System.out.print(curr.key+" ");
				BFS.enqueue(curr.left);
				BFS.enqueue(curr.right);
			}
		}
		System.out.println("");
	}
	
	public boolean find(int key){
		Node pointer=root;
		while(pointer!=null){
			if(pointer.key==key)return true;
			else if(pointer.key>key)pointer=pointer.left;
			else pointer=pointer.right;
		}
		return false;
	}
	
	public void insert(int key){
		if(root==null)root=new Node(key);
		else {
			Node pointer=root;
			Node parent=root;
			while(pointer!=null){
				if(pointer.key==key)return;
				else if(pointer.key>key){
					parent=pointer;
					pointer=pointer.left;
				}
				else {
					parent=pointer;
					pointer=pointer.right;
				}
			}
			if(parent.key>key)parent.left=new Node(key);
			else parent.right=new Node(key);
		}
	}
	
	private Node getSuccessorParent(Node curr){	
		Node parent=curr;
		curr=curr.right;
		if(curr==null)return parent;
		else {
			while(curr.left!=null){
				parent=curr;
				curr=curr.left;
			}
			return parent;
		}
	}
	
	public void delete(int key){
		Node toDel=root;
		Node parent=root;
		while(toDel!=null){				// find the Node to be deleted and its parent
			if(toDel.key==key)break;
			else if(toDel.key>key){
				parent=toDel;
				toDel=toDel.left;
			}
			else {
				parent=toDel;
				toDel=toDel.right;
			}
		}
		if(toDel==null)return;			// if didn't find, terminate
		else if(toDel==root){			// to delete root is to be deleted
			if(root.right==null)root=root.left;		// no right tree
			else {									// there is right tree
				Node successorParent=getSuccessorParent(root);
				if(successorParent==root){			// the right child has no left child
					root=root.right;
					root.left=parent.left;
				}
				else {								// the right child has left child
					root=successorParent.left;
					successorParent.left=root.right;
					root.left=parent.left;
					root.right=parent.right;
				}
			}
		}
		else if(toDel.right==null){			// the Node to be deleted has no right child
			if(parent.key>toDel.key)parent.left=toDel.left;
			else parent.right=toDel.left;
		}
		else {							// the to-be-deleted Node has right child
			Node successorParent=getSuccessorParent(toDel);
			Node tmp;
			if(successorParent==toDel){		// the right child of to-be-deleted Node has no left child
				tmp=successorParent.right;
				tmp.left=toDel.left;
				if(parent.key>toDel.key)parent.left=tmp;
				else parent.right=tmp;
			}
			else {							// the right child of to-be-deleted Node has left child
				tmp=successorParent.left;
				successorParent.left=tmp.right;
				tmp.left=toDel.left;
				tmp.right=toDel.right;
				if(parent.key>toDel.key)parent.left=tmp;
				else parent.right=tmp;
			}		
		}
	}
	
	private class BSTIterator implements Iterator<Integer> {
		private Node curr;
		private Stack<Node> stack=new Stack<Node>();
		
		public BSTIterator(Node curr){
			this.curr=curr;
		}
		
		public boolean hasNext(){
			return !(stack.isEmpty() && curr==null);
		}
		
		public Integer next(){
			while(curr!=null){
				stack.push(curr);
				curr=curr.left;
			}
			Node tmp=stack.pop();
			curr=tmp.right;
			return tmp.key;
		}
	} 
	
	public BSTIterator iterator(){
		return new BSTIterator(root);
	}
}
