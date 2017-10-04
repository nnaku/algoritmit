public class ListItem {
<<<<<<< HEAD
	private String data;
	private ListItem tail;

	public ListItem(String data) {
		this.data = data;
		this.tail = null;
	}

	public ListItem(String data, ListItem tail) {
		this.data = data;
		this.tail = tail;
=======
	private String	data;
	private ListItem tail;
	
	public ListItem() {
		this.data = null;
		this.tail = null;
	}
	
	public ListItem(String data) {
		this.data = data;
		this.tail = null;
>>>>>>> 1926390dec322a785648105fa9628d2bff75f075
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
	
<<<<<<< HEAD
	 

=======
>>>>>>> 1926390dec322a785648105fa9628d2bff75f075
}
