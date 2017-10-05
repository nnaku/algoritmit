
public class BinaryTree {

	Node root;
	Node parent;

	public BinaryTree() {
		this.root = null;
		this.parent = null;
	}

	public BinaryTree(Node root, Node parent) {
		this.root = root;
		this.parent = parent;
	}

	public void insert(String data) {

		if (root.equals(null)) {
			Node node = new Node();
			node.setData(data);
			node.setHeight(height(node));
			this.root = node;
		}

		int dataKey = data.compareTo(root.getData());

		if (dataKey < 0) {
			root.getLeft().insert(data);
		} else {
			root.getRight().insert(data);
		}

	}

	public int height(Node root) {
		int l = 0;
		int r = 0;

		if (root.getLeft().equals(null) && root.getRight().equals(null)) {
			return 0;
		} else {
			if (!root.getLeft().equals(null)) {
				l = height(root.getLeft().root);
			}
			if (!root.getRight().equals(null)) {
				r = height(root.getRight().root);
			}
			return Math.max(l, r) + 1;
		}
	}

}
