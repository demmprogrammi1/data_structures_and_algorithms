
public class LinkedQueue<E> {
 private static class Node<E> {
	 private E data;
	 private Node<E> next;
	 public Node(E val) {
		 data=val;
	 }
 }
 
 private Node<E> head,tail;
 
 private int size;
 
 public int size() {
	 return this.size;
 }
 
 public LinkedQueue() {
	size=0;
    head=null;	
    tail=null;
 }
 void add(E val) {
	if(size==0) {
		head=new Node(val);
		tail=head;
	}
	else {
		tail.next=new Node(val);
		tail=tail.next;
	}
	size++;
 }
 public E gettail() {
	 return head.data;
 }
public E first() {
	if(size==0) try {
		throw new Exception(); } catch(Exception e) { System.out.print("no elements"); return null; }
	else
		return head.data;
}

public E remove() {
	if(size==0) try {
		throw new Exception(); } catch(Exception e) { System.out.print("exception"); return null; }
	else
	{
		E temp=head.data;
		head=head.next;
		size--;
		return temp;
	}
}

boolean is_empty() {
	return (size==0);
}

}
