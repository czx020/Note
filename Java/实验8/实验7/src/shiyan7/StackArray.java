package shiyan7;

public class StackArray {
	private int capacity;
	private int topIndex;
	private Object elements[];

	public StackArray(int capacity){
		this.capacity =capacity;
		this.elements = new Object[capacity];
		this.topIndex = -1;
	}

	public void clear() {
		this.topIndex = -1;
	}

	public boolean isEmpty() {

		return (this.topIndex ==-1)?true:false;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return (this.topIndex ==this.capacity)?true:false;
	}

	public void push(T element) {
		if(this.topIndex == this.capacity-1){
			System.out.print("栈已满，无法入栈！");
		}

		this.topIndex++;
		this.elements[topIndex]=element;
	}

	public T pop() {
		if(this.topIndex==-1){
			System.out.print("栈是空的，无法出栈！");
			return null;
		}
		this.topIndex = this.topIndex-1;

		return (T)this.elements[this.topIndex+1];
	}

	public T peek() {
		if(this.topIndex==-1){
			System.out.print("栈是空的，无法取栈顶元素！");
			return null;
		}
		return (T)this.elements[this.topIndex];
	}
		
}
