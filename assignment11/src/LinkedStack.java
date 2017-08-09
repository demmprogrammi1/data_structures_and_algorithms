
public class LinkedStack<E> {
	
private static class Node<E> {
	private E data;
	private Node<E> next;
	public Node(E val) {
		data=val;
	}
}

public LinkedStack() {
	size=0;
	head=null;
}
private Node<E> head;

private int size;

public int size() {
	return this.size;
	
}

public void add(E val) {
	Node node=new Node(val);
	node.next=head;
	head=node;
	size++;
}

public E peek() {
	if(size>0)
		return head.data;
	else
		return null;
}
public E pop() {
	if(size>0) {
		E temp=head.data;
		head=head.next;
		size--;
		return temp;
	}
	else try {
		throw new Exception();
	} catch(Exception e) { System.out.print("There are no elements"); return null; }
}
	
boolean is_empty() {
	return (size==0);
}

}
