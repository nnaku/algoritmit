public class Stack {
	String[] stack;
	private int index = -1;

	public Stack(int len) {
		stack = new String[len];
	}

	public StackIterator iterator() {
		return new StackIterator(this);
	}

	public void push(String aData) {
		stack[++index] = aData;
	}

	public String pop() {
		if(index<0)return null;
		return stack[index--];
	}

	public int amount() {
		return index+1;
	}
	public String element(int index) {
		return stack[index];
	}

	public void printItems() {
		for(int i = index;i>=0;i--) {
			System.out.println(stack[i]);
		}

	}
}
