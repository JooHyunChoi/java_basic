package day10hw;


public class MyStack {
	int[] intArr;
	private int top=-1;
	private int size;
	public MyStack() {
		intArr = new int[10];
	}
	
	public MyStack(int size) {
		this.size = size;
		if(size < 0) {
			intArr = new int[10];
		} else {
			intArr = new int[size];
		}
		
	}
	
	public void push(int a) {
		top++;
		intArr[top] = a;
	}
	
	public boolean isEmpty() {
		boolean flag = false;
		if(top == -1) {
			flag = true;
		}
		return flag;
	}
	
	public boolean isFull() {
		boolean flag = false;
		if(top+1 == size) {
			flag = true;
		}
		return flag;
	}
	
	public int top() {
		if(this.isEmpty()) {
			return -1;
		} else {
			return intArr[top];
		}
	}
	
	public int pop() {
		int temp;
		if(!this.isEmpty()) {
			temp = intArr[top];
			top--;
			return temp;
		} else {
			return -1;
		}
	}
	
	
	
	
}
