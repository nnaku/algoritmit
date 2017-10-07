import java.util.Arrays;

public class BinarySearchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch bins = new BinarySearch();
		int count = 30;
		int[] test = new int[count];
		for (int i = 0;i<count;i++) {
			int random = (int)(Math.random() * count)+1;
			test[i] = random;
			bins.add(random);
		}
		System.out.println("Append order");
		System.out.println(Arrays.toString(test).toString()+"\n");
		System.out.println("Current order");
		System.out.println(bins.toString()+"\n");
		
		for (int j = 0;j<count/2;j++) {
			int random = (int)(Math.random() * count)+1;
			System.out.println("Finding "+random+"\tStatus : "+bins.find(random));
			
		}
		
	}

}
