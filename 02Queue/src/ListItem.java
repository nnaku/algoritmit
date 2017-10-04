public class ListItem {

	private String	data;
	private ListItem tail;
	
	public ListItem() {
		this.data = null;
		this.tail = null;
	}
	
	public ListItem(String data) {
		this.data = data;
		this.tail = null;

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListItem getTail() {
		return tail;
	}

	public void setTail(ListItem tail) {
		this.tail = tail;
	}
	
}
