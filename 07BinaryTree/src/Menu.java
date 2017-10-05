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
		char select;
		BinaryTree tree = new BinaryTree();
		String data;
		do {

			System.out.println("\n\t\t\t1. Lisää valmis data.");
			System.out.println("\t\t\t2. Etsi avaimella.");
			System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
			System.out.println("\t\t\t4. Poista avaimella.");
			System.out.println("\t\t\t5. Puun korkeus.");
			System.out.println("\t\t\t6.  ");
			System.out.println("\t\t\t7. lopetus ");
			System.out.print("\n\n"); // tehdään tyhjiä rivejä
			select = Lue.merkki();
			switch (select) {
			case '1':
				tree.insert("eeeee");		// 5
				tree.insert("ccc");			// 3
				tree.insert("a");			// 1
				tree.insert("dddd");		// 4
				tree.insert("bb");			// 2
				tree.insert("iiiiiiiii");	// 9
				tree.insert("ggggggg");		// 7
				tree.insert("hhhhhhhh");	// 8
				tree.insert("ffffff");		// 6
				tree.insert("jjjjjjjjjj");	// 10
				System.out.println("Anna uusi avain (merkkijono)");
				data = new String(Lue.rivi());
				tree.insert(data);

				
//				tree.insert("dddd");
//				tree.insert("ccc");
//				tree.insert("ggggggg");
//				tree.insert("bb");
//				tree.insert("ffffff");
//				tree.insert("iiiiiiiii");
//				tree.insert("a");
//				tree.insert("eeeee");
//				tree.insert("hhhhhhhh");
//				tree.insert("jjjjjjjjjj");
				
				System.out.println("\nData listätty!");
				System.out.println("Esijärjestys.\n");
				tree.preOrder();
				
				
				break;
			case '2':
				System.out.println("Anna etsittävä avain (merkkijono)");
				data = Lue.rivi();
				if (tree.find(data) != null) {
					System.out.println("Avain löytyi.");
				} else {
					System.out.println("Avainta ei löytynyt.");
				}
				break;
			case '3':
				tree.preOrder();
				break;
			case '4':
				System.out.println("Anna poistettava avain (merkkijono)");
				data = new String(Lue.rivi());
				if (tree.find(data) != null) {
					tree.delete(data);
					System.out.println("Avain "+data+" poistettu.\n");
					tree.preOrder();
				}else {
					System.out.println("Avainta ei löytynyt.\n");
				}
				break;
			case '5':
				int height = 0;
				System.out.println("Anna haluamasi avain");
				data = Lue.rivi();
				BinaryTree tmp = tree.find(data);
				if (tmp != null) {
					height = tree.getTreeHeight(tmp);
					System.out.println("Puun korkeus "+height);
				} else {
					System.out.println("Avainta ei löytynyt.");
				}
				break;

			case '6':
				break;
			}
		} while (select != '6');
	}
	// printMenu loppuu
	// ----------------------------------------------------------------
}
