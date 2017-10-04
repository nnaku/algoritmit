/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kamaj
 */
public class BinaryTree {

	private Node root;

	public BinaryTree(String rootValue) {
		root = new Node(rootValue);
	}

	public BinaryTree() {
		root = null;
	}
	/*
	 * public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){ root
	 * = new Node(rootValue, left, right); }
	 */

	public void insert(String aData) {
		int aDatalength = aData.length();
		if (root == null) { // onko puu tyhjä?
			root = new Node(aData); // luodaan uusi solmu
		} else if (root.getData().length() > aDatalength) {
			// jos suuren arvo on suurempi, mennään vasemmalle
			if (root.left() != null) { // pääseekö vasemmalle?
				root.left().insert(aData);
			} else { // paikka löytyi
				root.setLeft(new BinaryTree(aData));
			}
		} else {
			if (root.right() != null) {
				root.right().insert(aData);
			} else {
				root.setRight(new BinaryTree(aData));
			}
		}
	}


	public BinaryTree find(String aData) {
		int aDatalength = aData.length();
		if (root == null || root.getData().equals(aData)) {
			return this; // palautetaan null tai löytynyt alipuu
		} else if (root.getData().length() > aDatalength) {
			// haetaan vasemmalta
			if (root.left() != null) {
				return root.left().find(aData);
			} else {
				return null;
			}
		} else {
			// haetaan oikealta
			if (root.right() != null) {
				return root.right().find(aData);
			} else {
				return null;
			}

		}
	}

	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ',');
			if (root.left() != null) // pääseeekö vasemmalle?
				root.left().preOrder();
			if (root.right() != null) // pääseekö oikealle?
				root.right().preOrder();
		}

	}

	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}
}
