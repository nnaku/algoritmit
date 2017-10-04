public class BinaryTree {

	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(String rootValue) {
		root = new Node(rootValue);
	}
		
	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
	}
	
	public void insert(String aData) {
		int aDatalength = aData.length();
		if (root == null) { 
			root = new Node(aData);
		} else if (root.getData().length() > aDatalength) {
			if (root.left() != null) { 
				root.left().insert(aData);
			} else {
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
			return this;
		} else if (root.getData().length() > aDatalength) {
			if (root.left() != null) {
				return root.left().find(aData);
			} else {
				return null;
			}
		} else {
			if (root.right() != null) {
				return root.right().find(aData);
			} else {
				return null;
			}

		}
	}
	
	public BinaryTree delete(String aData) {
		if (root == null) {
			return null;
		} else if (root.getData().length() > aData.length()) {
			root.setLeft(root.left().delete(aData));
		} else if (root.getData().length() < aData.length()) {
			root.setRight(root.right().delete(aData));
		} else {
			if (!root.getData().equals(aData)) {
				if (root.right() != null) {
					root.setRight(root.right().delete(aData));
				}
				return null;
			} else {
				if (root.left() != null && root.right() != null) {
					Node temp = root;
					Node minNodeForRight = findMin(temp.right().root);
					root.setData(minNodeForRight.getData());
					root.right().delete(minNodeForRight.getData());

				} else if (root.left() != null) {
					root = root.left().root;
				} else if (root.right() != null) {
					root = root.right().root;
				} else
					root = null;
			}
		}
		return this;
	}

	public Node findMin(Node root) {
		if (root.left() == null)
			return root;
		else {
			return findMin(root.left().root);
		}
	}
	
	public int getTreeHeight(BinaryTree tree) {
		int l = 0;
		int r = 0;
		if (null == tree.root.left() && null == tree.root.right()) {
			return 0;
		} else {
			if (tree.root.left() != null) {
				l = getTreeHeight(tree.root.left());
			}
			if (tree.root.right() != null) {
				r = getTreeHeight(tree.root.right());
			}
			return Math.max(l, r) + 1;
		}
	}
	
	public void preOrder() {
		if (root != null) {
			System.out.println(root.getData() + ",");
			if (root.left() != null)
				root.left().preOrder();
			if (root.right() != null)
				root.right().preOrder();
		}
	}
}
