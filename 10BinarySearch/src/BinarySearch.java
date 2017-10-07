import java.util.Arrays;

public class BinarySearch {
	int[] array;

	public BinarySearch() {
		this.array = new int[] {};
	}

	public void add(int data) {
		array = add(array, data);

	}

	public boolean find(int key) {
		return find(array, key);
	}

	private int[] add(int[] array, int data) {
		// First element of array
		if (array.length < 1) {
			array = new int[1];
			array[0] = data;
			return array;
		}
		// Second element of array
		else if (array.length < 2) {
			int first = array[0];
			array = new int[array.length + 1];
			if (data <= first) {
				array[0] = data;
				array[1] = first;
			} else {
				array[0] = first;
				array[1] = data;
			}
			return array;
		}

		// Array has 3 or more elements.

		// We will concatenate start + data + end on this array and return it.
		int[] newArray;
		// First half of array.
		int[] start = Arrays.copyOfRange(array, 0, array.length / 2);
		// Second half of array.
		int[] end = Arrays.copyOfRange(array, array.length / 2, array.length);

		// If position found, append data.
		if (start[start.length - 1] <= data && data <= end[0]) {
			newArray = new int[start.length + end.length + 1];
			System.arraycopy(start, 0, newArray, 0, start.length);
			newArray[start.length] = data;
			System.arraycopy(end, 0, newArray, start.length + 1, end.length);
		}
		// Otherwise split target half again.
		else {
			if (data < end[0]) {
				start = add(start, data);
			} else {
				end = add(end, data);
			}
			// Concatenate arrays.
			newArray = new int[start.length + end.length];
			System.arraycopy(start, 0, newArray, 0, start.length);
			System.arraycopy(end, 0, newArray, start.length, end.length);
		}
		return newArray;
	}

	
	private boolean find(int[] array, int key) {

		if (array.length > 2) {
			int edge = array.length / 2;
			int[] start = Arrays.copyOfRange(array, 0, edge);
			int[] end = Arrays.copyOfRange(array, edge, array.length);
			if(start[start.length-1] == key || key == end[0]) {
				return true;
			}
			else if (key < end[0]) {
				return find(start, key);
			} else {
				return find(end, key);
			}
		}
		// last one ;(
		else if (array[0] == key) {
			return true;
		}
		return false;
	}



	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
