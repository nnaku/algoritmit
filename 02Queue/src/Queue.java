public class Queue {
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
}
