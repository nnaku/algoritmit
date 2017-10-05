public class TestMain {

	public static void main(String arg[]) {
		BinaryTree b = new BinaryTree();

		b.addNode(3);
		b.addNode(8);
		b.addNode(1);
		b.addNode(4);
		b.addNode(6);
		b.addNode(2);
		b.addNode(10);
		b.addNode(9);
		b.addNode(20);
		b.addNode(25);
		b.addNode(15);
		b.addNode(16);
		System.out.print("Postorder\n\t");
		b.toPostorder(b.root);
		System.out.print("\nInorder\n\t");
		b.toInorder(b.root);
		System.out.print("\nPreorder\n\t");
		b.toPreorder(b.root);

	}
}
