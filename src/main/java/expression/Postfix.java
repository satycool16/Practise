package main.java.expression;
import java.util.Stack;

public class Postfix {
	private static void evaluate(String expression){
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<expression.length(); i++){
			char c = expression.charAt(i);
			if (Character.isDigit(c)){
				stack.push(c-'0');
			}
			else {
				Integer val2 = stack.pop();
				Integer val1 = stack.pop();
				switch (c){
					case '+':
						stack.push(val1+val2);
						break;
					case '-':
						stack.push(val1-val2);
						break;
					case '/':
						stack.push(val1/val2);
						break;
					case '*':
						stack.push(val1*val2);
						break;
				}
			}
		}
		System.out.println(stack.pop());
	}
	public static void main(String[] args) {
		String exp="231*+9-";
		evaluate(exp);
	}
}
