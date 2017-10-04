import java.util.Random;

public class MergeSort {
	
	final private int MAX;
	private int[] tau;
	private long lkm = 0;
	

	public MergeSort(int mAX) {
		MAX = mAX;
		tau= new int[mAX];
	}
	
	public long mergeSort() {
        int[] a= new int[MAX];
        int i;
        Random r = new Random(); //luodaan satunnaislukugeneraattori
        System.out.println("\nGeneroidaan syöttöaineisto: ");
        for (i=0;i<MAX;i++) {
            a[i] = r.nextInt(1000); //generoidaan luvut
            System.out.print(a[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nSuoritetaan lomituslajittelu, paina Enter ");
        //Lue.merkki();

        mergeSort(a, 0, MAX-1);
        for (i=0;i<MAX;i++) {
            System.out.print(a[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        
        return lkm;
    }

    

    //oletus: osataulukot t[p..q] ja t[q+1...r] ovat järjestyksess„
	private void merge(int t[], int p, int q, int r) {
        //i osoittaa 1. osataulukkoa, j osoittaa 2. osataulukkoa
        // k osoittaa aputaulukkoa, johon yhdiste kirjoitetaan.
        int i=p, j=q+1, k=0;
        lkm++;
        lkm++;
        while(i<q+1 && j<r+1) {
        	lkm++;
        	if (t[i]<t[j]) {
        		tau[k++]=t[i++];
        	} else {
        		tau[k++]=t[j++];
            }
        	lkm++;
        	lkm++;
        }
        //toinen osataulukko käsitelty, siirretään toisen käsittelemättömät
        lkm++;
        while (i<q+1){
        	tau[k++]=t[i++];
        	lkm++;
        }
        
        lkm++;	
        while (j<r+1){
        	tau[k++]=t[j++];
        	lkm++;
        }
        lkm++;
        //siirretään yhdiste alkuperäiseen taulukkoon
        for (i=0;i<k;i++) {
                t[p+i]=tau[i];
                lkm++;
        }
    }

	private void mergeSort(int t[],  int alku,  int loppu) {
        int ositus;
        long la, ll, lt;
        lkm++;
        if (alku<loppu) { //onko väh. 2 alkiota, että voidaan suorittaa ositus

                la=alku; ll=loppu;
                lt=(la+ll)/2;
                ositus=(int)lt;
                mergeSort(t, alku, ositus);//lajitellaan taulukon alkupää
                mergeSort(t, ositus+1, loppu);//lajitellaan taulukon loppupää
                merge(t, alku, ositus, loppu);//yhdistetään lajitellut osataulukot
        }

    }
}
