
public class Node {
	String data;
	int height;
	BinaryTree left;
	BinaryTree right;

	public Node() {
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	
	public Node(String data, int height, BinaryTree left, BinaryTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = height;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public BinaryTree getLeft() {
		return left;
	}


	public void setLeft(BinaryTree left) {
		this.left = left;
	}


	public BinaryTree getRight() {
		return right;
	}


	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	
}
