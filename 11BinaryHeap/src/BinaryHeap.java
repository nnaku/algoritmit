
public class BinaryHeap {
	public int size;
	public int [] mH;
	public int position;
    
	// Alustus.
	public BinaryHeap(int size){
		this.size=size;
		mH = new int [size+1];
		position = 0;
	}
	// Jonon alkioiden sijoittaminen kasaan.
	public void createHeap(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){ 
				insert(arrA[i]);
			}
		}		
	}
	// Tulostaa kasan.
	public void display(){
		for(int i=1;i<mH.length;i++){
			System.out.print(" " + mH[i]);			
		}
		System.out.println("");
	}
	
	// Tarkastaa onko luku kasan ensimmäinen, Ja pitää kirjaa kasan viimeisestä indeksitä
	public void insert(int x){ // 1
		if(position==0){
                        
			mH[position+1]=x;
			position = 2;
                        
		}else{
                       
			mH[position++]=x;
			bubbleUp();
		}
                
	}
	
	// Kasaa kasatessa, alkio sijoitetaan seuraavaan vapaasee (viimeiseen) alkioon.	
	//
	//        ____1____
	//     __2__     __3__
	//    4     5   6     7
	//
	// Jokaisen alkion indeksi jaettuna kahteen, osoittaa (kokonaisluvulla) tämän alkion vanhempaan.
	// Tätä hyväksi käyttäen, data kuljetetaan kasan juurta kohti, niin kauan kuin vahemman avain on pienempi.
	//	
	
	public void bubbleUp(){
		int pos = position-1;
                
		while(pos>0 && mH[pos/2]>mH[pos]){
                        
			int y = mH[pos]; 
               
			mH[pos]=mH[pos/2];
			mH[pos/2] = y;
			pos = pos/2;
     
		}

	}
	
	// Kasan juuresta poistetaan pienin alkio, ja kasan juureen tuodaan "viimeisin" alkio.
	public int extractMin(){
		int min = mH[1];
		mH[1]=mH[position-1];
		mH[position-1]=0;
		position--;		
		sinkDown(1);
		return min;
	}
	
	// Kasan juureen tuotu "viimeisin" alkio, "valuu" kasaa alas, niin kauan kun alkion lapselta löytyy pienempi arvo!
	public void sinkDown(int k){
		int smallest =k;
		if(2*k<position && mH[smallest]>mH[2*k]){
			smallest = 2*k;
		}
		if(2*k+1<position && mH[smallest]>mH[2*k+1]){
			smallest = 2*k+1;
		}
		if(smallest!=k){
			swap(k,smallest);
			sinkDown(smallest);
		}
				
	}
	// Jos lapsella pienempi arvo, suoritetaan vaihto!
	public void swap(int a, int b){
		//System.out.println("swappinh" + mH[a] + " and " + mH[b]);
		int temp = mH[a];
		mH[a] = mH[b];
		mH[b] = temp;
	}
	
	public static void main(String args[]){
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		BinaryHeap m = new BinaryHeap(arrA.length);
		System.out.print("\nMin-Heap : ");
		m.createHeap(arrA);		
		m.display();
		System.out.print("Extract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + m.extractMin());
		}
		
	}
	
		
}