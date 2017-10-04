/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ListItem {
    
    private String data;
	private ListItem next;

	public ListItem(String data, ListItem next) {
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ListItem getNext() {
		return next;
	}
	public void setNext(ListItem next) {
		this.next = next;
	}
}
