public class BinaryTree {
	public Node root;
	public BinaryTree() {
		this.root = null;
	}

	public boolean find(int data) {
		Node current = root;
		while (current != null) {
			if (data == 0) {
				return true;
			} else if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
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
		while (current.data == data) {
			parent = current;
			if (data < current.data) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current.equals(null)) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.left.equals(null) && current.right.equals(null)) {
			if (current.equals(root)) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.right.equals(null)) {
			if (current.equals(root)) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left.equals(null)) {
			if (current.equals(root)) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (!current.left.equals(null) && !current.right.equals(null)) {

			// now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		// check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
		// successsorParent
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	// Return height of node!
	public int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	// Postorder print.
	public void toPostorder(Node node) {
		if (node == null)
			return;
		toPostorder(node.left);
		toPostorder(node.right);
		System.out.print(" " + node.data);
	}
	// Inorder print.
	public void toInorder(Node node) {
		if (node == null)
			return;
		toInorder(node.left);
		System.out.print(" " + node.data);
		toInorder(node.right);
	}
	// Preorder print.
	public void toPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(" " + node.data);
		toPreorder(node.left);
		toPreorder(node.right);
	}
}