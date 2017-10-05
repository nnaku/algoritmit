/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author kamaj
 */
public class Node {
	
	private Node parent;
	private String data;
    private BinaryTree left;
    private BinaryTree right;

    public Node(String value) {
        data = new String(value);
        parent = null;
        left = right = null;
    }
    public  Node (String value, Node parent, BinaryTree left, BinaryTree right) {
    	this.parent = parent;
        data = new String(value);
        this.left = left;
        this.right = right;
    }
    public String getData() {
        return data;
    }

    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public Node getParent() {
        return parent;
    }
    public void setData(String data) {
		this.data = data;
	}
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }
    public void setParent(Node node) {
    	this.parent = node;
    }


}
