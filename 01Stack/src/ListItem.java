
public class ListItem {
	private String	data;
	private ListItem next;
	
	public ListItem(String data, ListItem next) {
		this.data = data;
		this.next = next;
	}
	public String getData() {
		return data;
	}
	public ListItem getNext() {
		return next;
	}

}
