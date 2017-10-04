import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void saveToFile(int elements, long select, long merge,
			long quick) {
		try {
			String filename = ".//sortAlgorithms";
			// the true will append the new data
			FileWriter fw = new FileWriter(filename, true);
			// appends the string to the file
			fw.write(elements + ","
					+ (select + "," + (merge + "," + (quick + "\n"))));
			fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		int rows = 1000;
		for (int i = 0; i < rows; i++) {
			int j = 30000;
			long select = 900030002;//new SelectSort(j).selectSort();
			long merge = new MergeSort(j).mergeSort();
			long quick = new QuickSort(j).quickSort();
			saveToFile(j, select, merge, quick);

		}
		try {
			String filename = ".//sortAlgorithms";
			// the true will append the new data
			FileWriter fw = new FileWriter(filename, true);
			// appends the string to the file
			fw.write("AVG,=AVERAGE(B2:B"+(rows+1)+"),=AVERAGE(C2:C"+(rows+1)+"),=AVERAGE(D2:D"+(rows+1)+"),");
			fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
			System.exit(0);
		}

	}

}
