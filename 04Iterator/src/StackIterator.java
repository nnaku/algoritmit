import java.util.Iterator;

public class StackIterator implements Iterator<Object>{
	private int index;
	private Stack container;

	StackIterator(Stack c) {
		container = c;
		index = container.amount();
		
	}

	public boolean hasNext() {
		if (index-- <= 0)
			return false;
		else
			return true;
	}

	public Object next() {
		return container.element(index);
	}

}
