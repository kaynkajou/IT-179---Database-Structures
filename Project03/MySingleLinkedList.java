package edu.ilstu;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MySingleLinkedList<E> implements Iterable<E> {
	
	// need a node class
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		private Node(E data) {
			this.data = data;
		}
		
		private Node(E data, Node<E> node) {
			this.data = data;
			next = node;
		}
	}
	
	// instance variables for the list
	private Node<E> head;
	private int size;
	
	// the helper method, add
	// this is to add a node to 
	// the front of the list
	public void addFirst(E data) {
		head = new Node<>(data,head);
		size++;
	}
	
	// the helper method, addAfter
	// this is to add a node after a 
	// particular node
	
	private void addAfter(Node<E> node, E data) {
		Node<E> newNode = new Node<>(data);
		newNode.next = node.next;
		node.next = newNode;
		// node.next = new Node<>(data, node.next);
		size++;
	}
	
	// Another helper method
	private Node<E> getNode(int index){
		Node<E> tempRef = head;
		for(int i=0; i<index; ++i)
			tempRef = tempRef.next;
		return tempRef;
	}
	
	public E set(int index, E data){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
//		Node<E> priorNode = get(index-1);
//		Node<E> returned = priorNode.next;
//		priorNode.next = new Node<>(data,priorNode.next.next);
		Node<E> currentNode = getNode(index);
		E returned = currentNode.data;
		currentNode.data = data;
		return returned;
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(E target) {
		if(head == null)
			return -1;
		else {
			Node<E> nodeRef = head;
			
//			for(int i=0; i<size; ++i) {
//				if(nodeRef.data.equals(target))
//					return i;
//				nodeRef = nodeRef.next;
//			}
			
			int i = 0;
			while(nodeRef != null) {
				if(nodeRef.data.equals(target))
					return i;
				nodeRef = nodeRef.next;
				++i;
			}
			return -1;
		}
	}
	
	// The add method
	public void add(int index, E data) {
		// check index
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		if(index == 0)
			addFirst(data);
		else {
			//Get the prior node
			Node<E> priorNode = getNode(index-1);
			addAfter(priorNode,data);
		}

	}
	
	// add a node to the end of a list
	public boolean add(E data) {
		add(size,data);
		return true;
	}
	
	// The removeFirst helper method
	private E removeFirst() {
		//Check if the list is empty
		if (head == null)
			return null;
		else {
			E returned = head.data;
			head = head.next;
			size--;
			return returned;
		}
	}
	
	// The removeAfter helper method
	private E removeAfter(Node<E> node) {
		//1. check to see if it is at the end of the list
		if (node.next == null)
			return null;
		else {
			E returned = node.next.data;
			node.next = node.next.next;
			size--;
			return returned;
		}
	}
	
	// The public remove method
	public E remove(int index) {
		// size is allowed, you will just get null if index == size
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		else if(index == 0){
			return removeFirst();
		}else {
			Node<E> priorNode = getNode(index-1);
			return removeAfter(priorNode);
		}
	}
	
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		Node<E> theNode = getNode(index);
		return theNode.data;
	}
	
	//For fun
	public void reverse() {
		Node<E> futureHead;
		// get the last node as the future head
		futureHead = getNode(size-1);
		// append all other nodes in the reversed order
		Node<E> tempRef = futureHead;
		for(int i=size-2; i>=0; --i) {
			tempRef.next = getNode(i);
			tempRef = tempRef.next;
		}
		// update head
		tempRef.next = null;
		head = futureHead;
	}
	
	public void reverse2() {
		for(int i=0; i<size-1;++i) {
//			E data = remove(size-1);
//			add(i,data);
			add(i,remove(size-1));
		}
		
	}
	
	//For fun as well
	public void swapFirstAndLast() {
		Node<E> futureTail = head;
		Node<E> futureHead = getNode(size-1);
		Node<E> secondToLast = getNode(size-2);
		
		//setup the head
		futureHead.next = head.next;
		head = futureHead;
		
		//setup the tail
		secondToLast.next = futureTail;
		futureTail.next = null;
	}

//	public String toString() {
//		
//		String result = "[";
//		for(int i=0; i<size; ++i) {
//			result += get(i);
//			if (i<size-1)
//				result += ", ";
//		}
//		result += "]";
//		return result;
//	}
	
	//a more efficient way
	public String toString() {
		
		Iterator<E> iter = new Iter();
		
		String result = "[";
		int counter = 0;
		while(iter.hasNext()) {
			result += iter.next();
			if(counter < size-1)
				result += ", ";
			counter++;	
		}
		
//		for(int i=0; i<size; ++i) {
//			result += get(i);
//			if (i<size-1)
//				result += ", ";
//		}
		result += "]";
		return result;
	}

//private class MakeIterator implements Iterator<E>{
//	
//	private Node<E> lastNode;
//	private Node<E> nextNode;
//	
//	private MakeIterator() {
//		nextNode =  head;
//	}
//
//	@Override
//	public boolean hasNext() {
//		return nextNode != null;
//	}
//
//	@Override
//	public E next() {
//		if(hasNext()) {
//			lastNode = nextNode;
//			nextNode = nextNode.next;
//			return lastNode.data;
//		}else 
//			throw new NoSuchElementException();
//	}
//}

	private class Iter implements Iterator<E>{
		
		private Node<E> prevNode;
		private Node<E> seenNode;
		private Node<E> nextNode;
		
		private Iter() {
			nextNode = head;
		}
	
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}
	
		@Override
		public E next() {
			if(hasNext()) {
				if(seenNode != null)
					prevNode = seenNode;
				seenNode = nextNode;
				nextNode = nextNode.next;
				return seenNode.data;
			}else 
				throw new NoSuchElementException();
		}
	
	public void remove() {
		if(seenNode == null) 
			throw new IllegalStateException("IllegalStateException: ");	
		if(seenNode == head){
			// to remove head
			head = nextNode;
		}else {
			prevNode.next = nextNode;
			
		}
		seenNode = null;
		size--;
			
	}
}



	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iter();
	}
	
	
	/*
	 * Using anonymous class
	 * 
	 */
	
//	public Iterator<E> iterator() {
//		// TODO Auto-generated method stub
//		return new Iterator<>() {
//		 Node<E> prevNode;
//		 Node<E> seenNode;
//		 Node<E> nextNode = head;
//		
//		
//
//		public boolean hasNext() {
//			return nextNode != null;
//		}
//
//		public E next() {
//			if(hasNext()) {
//				prevNode = seenNode;
//				seenNode = nextNode;
//				nextNode = nextNode.next;
//				return seenNode.data;
//			}else 
//				throw new NoSuchElementException();
//		}
//		
//		public void remove() {
//			if(seenNode == null) {
//				throw new IllegalStateException("IllegalStateException: ");
//			}else if(seenNode == head){
//				// to remove head
//				seenNode = null;
//				head = nextNode;
//				size--;
//			}else {
//				prevNode.next = nextNode;
//				seenNode = null;
//				size--;
//			}
//				
//		}
//		};
//	}
	
	

}
