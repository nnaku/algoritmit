
public class Stack {

	private ListItem top; // top of stack
	private int size; // stack length
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}

	// create new member and set it top of the stack
	public void push(String aData){
		size++;
		ListItem newItem = new ListItem(aData,top);
		top = newItem;
		
	}
	
	// remove member from top of the stack, if stack is empty return null
	public ListItem pop(){
		ListItem popped = top;
		if(top != null){
			size--;
			ListItem newTop = top.getNext();
			top = newTop;
		}
		return popped;
	}

	// get number of members in stack
	public int getSize() {
		return size;
	}
	
	public void printItems(){
		ListItem currentItem = top;
		String stack = "";
		while(currentItem != null){
			stack += currentItem.getData();
			currentItem = currentItem.getNext();
		};
		System.out.print(stack);
	}
	
}
