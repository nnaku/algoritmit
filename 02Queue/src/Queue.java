public class Queue {
<<<<<<< HEAD
	private ListItem head; //top of queue
	private int size; // stack length

	public Queue() {
		this.head = null;
		this.size = 0;
	}
	// find tail
	private ListItem findTail(ListItem head){
		if(head.getTail() == null){
			return head;
		}
		return findTail(head.getTail());
	}
	// add item to tail
	public void push(String aData) {
		ListItem newItem = new ListItem(aData, null);
		if(head == null){
			head = newItem;
		}else{
			findTail(head).setTail(newItem);
		}
		size++;
	}
	// queue length
	public int getSize() {
		return size;
	}

	// remove member from top of the queue, if stack is empty return null
	public ListItem pop() {
		if(head != null){
			ListItem pop = head;
			head = head.getTail();
			size--;
			return pop;
			
		}
		return head;
	}

	// get all items of queue
	public void printItems() {
		ListItem currentItem = head;
		String stack = "";
		while (currentItem != null) {
			stack += currentItem.getData();
			currentItem = currentItem.getTail();
		}

		System.out.print(stack);
	}

=======
	private ListItem head;
	private int size; 
	
	public Queue() {
		this.head = new ListItem();
		this.size = 0;
	}

	public void pushItem(String aData){
		ListItem currentItem = head;
		while(currentItem.getTail() != null) {
			currentItem = currentItem.getTail();
		}
		currentItem.setTail(new ListItem(aData));
		size++;	
	}
	
	public ListItem popHead() {
		if(size > 0) {
			ListItem rVal = head.getTail();
			head.setTail(rVal.getTail());
			size--;
			return rVal;
		}
		return null;
	}
	
	public void printItems() {
		String items = "";
		ListItem currentItem = head;
		while(currentItem.getTail() != null) {
			currentItem = currentItem.getTail();
			items += currentItem.getData()+" ";
		}
		System.out.print(items);
	}
	
	public int getSize() {
		return size;
	}
>>>>>>> 1926390dec322a785648105fa9628d2bff75f075
}
