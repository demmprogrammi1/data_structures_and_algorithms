
public class stack {
	private int pointer;
	private int size;
	private int[] array;
	
	public stack(int size) {
		this.size=size;
		array=new int[this.size];
		pointer=-1;
	}
	public boolean isEmpty() {
		return (size==0);
	}
	public boolean isFull() {
		return (pointer==size-1);
	}
    public int pop() {
    	return array[pointer--];
    }
    public void push(int el) {
    	array[++pointer]=el;
    }
    public int Peek() {
    	return array[pointer];
    }
}
