
public class CalculatorStack {
	
	String[] stack;

	public CalculatorStack() {
		stack = new String[] {};
	}

	public void push(String data) {
		String[] tmp = stack;
		stack = new String[tmp.length+1];
		for(int i=0;i<tmp.length;i++) {
			stack[i] = tmp[i];
		}
		stack[stack.length-1] = data;
	}

	public String pop() {
		if(stack.length == 0)return null;
		String[] tmp = stack;
		stack = new String[tmp.length-1];
		for(int i=0;i<stack.length;i++) {
			stack[i] = tmp[i];
		}
		return tmp[tmp.length-1];
	}

	@Override
	public String toString() {
		String print = "";
		for(int i = 0;i<stack.length-1;i++) {
			print += (stack[i]+"|");
		}
		print += (stack[stack.length-1]);
		return print;
	}
	
}
