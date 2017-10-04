import java.util.Random;

public class QuickSort {
	
	final private int MAX;
	private long lkm = 0;
	
	public QuickSort(int mAX) {
		MAX = mAX;

	}
	
	public long quickSort() {
		int taulukko[] = new int[MAX];
		Random r = new Random();

		for (int i = 0; i < MAX; i++) {
			taulukko[i] = r.nextInt(1000);
			System.out.print(taulukko[i] + " ");
			if (i > 0 && i % 40 == 0) {// rivinvaihto
				System.out.println();
			}
		}
		System.out
				.println("\nJärjestellään käyttämällä Quicksorttia, paina Enter");
		//Lue.merkki();
		qs(taulukko, MAX);
		System.out.println("Valmis");
		System.out.println("Vertailujen lukumäärä: " + lkm);
		return lkm;
	}

	private void quickSort(int table[], int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		int mid, swap;

		mid = table[(lo0 + hi0) / 2];
		lkm++;
		while (lo <= hi) {
			lkm++;
			while (table[lo] < mid) {
				++lo;
			lkm++;
			}
			lkm++;
			while (table[hi] > mid) {
				--hi;
			lkm++;
			}
			lkm++;
			if (lo <= hi) {
				swap = table[lo];
				table[lo] = table[hi];
				++lo;
				table[hi] = swap;
				--hi;
			}
			lkm++;
		}
		lkm++;
		if (lo0 < hi) {
			quickSort(table, lo0, hi);
		}
		lkm++;
		if (lo < hi0) {
			quickSort(table, lo, hi0);
		}
		lkm++;
	}

	private void qs(int table[], int values) {
		quickSort(table, 0, values - 1);

		System.out.println("\nJärjestetty aineisto:\n");
		for (int i = 0; i < values; i++) {
			System.out.print(table[i] + " ");
			if (i > 0 && i % 40 == 0) { // rivinvaihto
				System.out.println();
			}
		}
	}
}
