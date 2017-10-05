import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kamaj
 */
public class Menu {
	// main
	// alkaa-----------------------------------------------------------------------------
	public static void main(String[] args) {

		printMenu();

	}

	// main loppuu
	// --------------------------------------------------------------------------
	// printMenu
	// alkaa------------------------------------------------------------------
	private static void printMenu() {
		int select;
		BinaryTree tree = new BinaryTree();
		int data = 0;
		do {

			System.out.println("\n\t\t\t0. Aja testit, esialustettuun puuhun!");
			System.out.println("\n\t\t\t1. Lisää uusi avain.");
			System.out.println("\t\t\t2. Etsi avaimella.");
			System.out.println("\t\t\t3. Poista avaimella.");
			System.out.println("\t\t\t4. Hae korkeus avaimella.");
			System.out.println("\t\t\t5. Tulosta puu esijärjestyksessä.");
			System.out.println("\t\t\t6. Tulosta puu sisäjärjestyksessä.");
			System.out.println("\t\t\t7. Tulosta puu jälkijärjestyksessä.");
			System.out.println("\n\t\t\t9. lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä

			select = Lue.kluku();

			switch (select) {
			case 1:
				System.out.println("Anna uusi avain (kokonaisluku)");
				tree.addNode(Lue.kluku());
				System.out.println("\nData listätty!");
				break;
			case 2:
				System.out.println("Anna etsittävä avain (kokonaisluku)");

				if (tree.find(Lue.kluku()) != null) {
					System.out.println("Avain löytyi.");
				} else {
					System.out.println("Avainta ei löytynyt.");
				}
				break;
			case 3:
				System.out.println("Anna poistettava avain (kokonaisluku)");
				data = Lue.kluku();
				if (tree.find(data) != null) {
					tree.delete(data);
					System.out.println("Avain " + data + " poistettu.\n");
				} else {
					System.out.println("Avainta ei löytynyt.\n");
				}
				break;
			case 4:
				int height = 0;
				System.out.println("Anna haluamasi avain (kokonaisluku)");
				Node haku = tree.find(Lue.kluku());
				if (haku != null) {
					height = tree.height(haku);
					System.out.println("Puun korkeus " + height);
				} else {
					System.out.println("Avaintaa ei löytynyt.");
				}
				break;
			case 5:
				System.out.println("Esijärjestys");
				tree.toPreorder(tree.root);
				System.out.println();
				break;
			case 6:
				System.out.println("Sisäjärjestys");
				tree.toInorder(tree.root);
				System.out.println();
				break;
			case 7:
				System.out.println("Jälkijärjestys");
				tree.toPostorder(tree.root);
				System.out.println();
				break;
			case 0:
				tree.addNode(5);
				tree.addNode(3);
				tree.addNode(1);
				tree.addNode(4);
				tree.addNode(2);
				tree.addNode(9);
				tree.addNode(7);
				tree.addNode(8);
				tree.addNode(6);
				tree.addNode(10);

				int[] alkiot = new int[] { 7, 8, 6 };

				for (int i : alkiot) {
					System.out.println("Esijärjestys");
					tree.toPreorder(tree.root);
					System.out.println("\n\nToimenpiteet alkiolle " + i);
					System.out.println("Haku\tKorkeus\tPoisto\tHaku");
					Node node = tree.find(i);
					if (node != null) {
						System.out.print(true + "\t");
					} else {
						System.out.print(false + "\t");
					}
					height = tree.height(node);
					System.out.print(height + "\t");

					System.out.print(tree.delete(i));
					node = tree.find(i);
					if (node != null) {
						System.out.print("\t" + true);
					} else {
						System.out.print("\t" + false);
					}

					System.out.println("\n_______________________________________________________________________\n");
				}
				System.out.println("Esijärjestys");
				tree.toPreorder(tree.root);
				System.out.println();
				Node node = tree.find(10);
				height = tree.height(node);
				System.out.println("\nSolmun 10: Korkeus " + height);
				tree.addNode(11);
				System.out.println("Solmu 11: listätty!");
				node = tree.find(10);
				height = tree.height(node);
				System.out.print("Solmun 10: Korkeus " + height);
				System.out.println("\n\nEsijärjestys");
				tree.toPreorder(tree.root);
				System.out.println();
				System.out.println("\nLopetus");
				select = 9;
				break;
			case 9:
				System.out.println();
				break;
			}
		} while (select != 9);
	}
	// printMenu loppuu
	// ----------------------------------------------------------------
}
