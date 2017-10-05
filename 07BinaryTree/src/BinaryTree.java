public class BinaryTree {

	private Node root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(String rootValue, Node parent) {
		root = new Node(rootValue);
		root.setParent(parent);
	}

	public void setLeft(BinaryTree tree) {
		root.setLeft(tree);
		tree.root.setParent(this.root);
	}

	public void setRight(BinaryTree tree) {
		root.setRight(tree);
		tree.root.setParent(this.root);
	}

	public void insert(String aData) {
		int aDatalength = aData.length();
		if (root == null) {
			root = new Node(aData);
		} else if (root.getData().length() > aDatalength) {
			if (root.left() != null) {
				root.left().insert(aData);
			} else {
				root.setLeft(new BinaryTree(aData,root));
			}
		} else {
			if (root.right() != null) {
				root.right().insert(aData);
			} else {
				root.setRight(new BinaryTree(aData,root));
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
				Node temp = root;
				if (root.left() != null && root.right() != null) {
					Node minNode = findMin(root.right().root);
					String data = minNode.getData();
					root = new Node(data, root, temp.left(), temp.right());
					root.right().delete(data);
				} else if (root.left() != null && root.right() == null) {
					root = new Node(aData, root,temp.left(), null);
				} else if (root.right() != null && root.left() == null) {
					String data = findMin(root.right().root).getData();
					root = new Node(data, root, null, temp.right());
					root.right().delete(root.getData());
				} else
					root = null;
			}
		}
		return this;
	}

	public Node findMin(Node root) {
		if (root.left().equals(null))
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
			if (null != tree.root.left()) {
				l = getTreeHeight(tree.root.left());
			}
			if (null != tree.root.right()) {
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
