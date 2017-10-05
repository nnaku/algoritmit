public class BinaryTree {
	public Node root;
	public BinaryTree() {
		this.root = null;
	}

	public Node find(int data) {
		Node current = root;
		while (current != null) {
			if (current.data == data) {
				return current;
			} else if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		
		while (true) {
			parent = current;
			if (data < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public boolean delete(int data) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while (current.data != data) {
			parent = current;
			if (data < current.data) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}

		// Lehti
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Jos yksi lapsi
		// Oikealla ?
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		// Vasemmalla?
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		// Jos kaksi lasta
		} else if (current.left != null && current.right != null) {
			Node follower = follower(current);
			if (current == root) {
				root = follower;
			} else if (isLeftChild) {
				parent.left = follower;
			} else {
				parent.right = follower;
			}
			follower.left = current.left;
		}
		return true;
	}
	// Poistettavan solmun jälkipyykki, kahden lapsen tapauksessa.
	private Node follower(Node deleleNode) {
		Node follower = null;
		Node parent = null;
		// Ensin oikealle.
		Node current = deleleNode.right;
		// Loopataan niin pitkään vasemmalle, että pienin avain löytyy.
		while (current != null) {
			parent = follower;
			follower = current;
			current = current.left;
		}
		
		if (follower != deleleNode.right) {
			parent.left = follower.right;
			follower.right = deleleNode.right;
		}
		return follower;
	}

	// Return height of node!
	public int height(Node node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	// Postorder print.
	public void toPostorder(Node node) {
		if (node == null)
			return;
		toPostorder(node.left);
		toPostorder(node.right);
		System.out.print("|" + node.data);
	}
	// Inorder print.
	public void toInorder(Node node) {
		if (node == null)
			return;
		toInorder(node.left);
		System.out.print("|" + node.data);
		toInorder(node.right);
	}
	// Preorder print.
	public void toPreorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print("|" + node.data);
		toPreorder(node.left);
		toPreorder(node.right);
	}
}