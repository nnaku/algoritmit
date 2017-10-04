import java.util.Random;

public class SelectSort {
	final private int MAX;
	private long lkm = 0;

	public SelectSort(int mAX) {
		MAX = mAX;
	}

	public long selectSort() {

		int[] taul = new int[MAX]; // taul tallettaa lajiteltavat tiedot
		int i, j, apu, pienin;
		Random r = new Random(); // luodaan satunnaislukugeneraattori
		System.out.println("Generoidaan syöttöaineisto: ");
		for (i = 0; i < MAX; i++) {

			taul[i] = r.nextInt(1000); // generoidaan luvut
			System.out.print(taul[i] + " ");
			if (i > 0 && i % 40 == 0) // rivinvaihto
				System.out.println();
		}
		System.out.println("\nSuoritetaan valintalajittelu, paina Enter ");
		//Lue.merkki();

		// ulompi forlause alla
		lkm++;
		for (i = 0; i < MAX; i++) {
			pienin = i;
			lkm++; // sisempi
			for (j = i + 1; j < MAX; j++) {
				/* löytyykö taulukon loppupäästä pienempää alkiota? */
				lkm++; // iflause alla
				if (taul[j] < taul[pienin]) {
					pienin = j;
				}
				lkm++;
				
			}
			lkm++;
			if (pienin != i) {
				/* jos löytyi suoritetaan alkioiden vaihto */
				apu = taul[pienin];
				taul[pienin] = taul[i];
				taul[i] = apu;
			}
			// ulompi forlause
		}
		lkm++;
		System.out.println();
		for (i = 0; i < MAX; i++) {
			System.out.print(taul[i] + " ");
			if (i > 0 && i % 40 == 0) // rivinvaihto
				System.out.println();
		}
		System.out.println("\nKuittaa tulos, paina Enter " + lkm);
		//Lue.merkki();
		return lkm;

	}
}
