import java.util.Iterator;

public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                Stack s = new Stack(10); // pino-olio
                String data; // Pinon data-kenttä
                do {

                        System.out.println("\n\t\t\t1. Alkion lisääminen.");
                        System.out.println("\t\t\t2. Alkion poistaminen.");
                        System.out.println("\t\t\t3. Pinon sisältö.");
                        System.out.println("\t\t\t4. Alkioiden lukumäärä.");
                        System.out.println("\t\t\t5. Pinon sisältö iteraattorilla selattuna.");
                        System.out.println("\t\t\t6. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna alkion sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            s.push(data);
                            break;
                        case '2':
                            String item = s.pop();
                            if (item == null)
                                System.out.println("Pino on tyhjä");
                            else
                                System.out.println("Poistettu alkio: "+item);
                            break;
                        case '3':
                            s.printItems();
                            break;
                        case '4':
                            System.out.println("Lukumäärä = "+s.amount());
                            break;
                        case '5':
                            Iterator<Object> itr = s.iterator();
                            while (itr.hasNext())
                                System.out.println(itr.next());
                            break;
                        case '6':
                            break;
                        }
                }
                while (select != '6');
        }
//printMenu loppuu ----------------------------------------------------------------
}