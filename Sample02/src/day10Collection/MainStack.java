package day10Collection;

import java.util.Stack;

public class MainStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
		
		
	}

}
