import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Postfix {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static CalculatorStack calStack = new CalculatorStack();

	static String read() {
		String value = null;
		boolean valid;
		do {
			try {
				value = stdin.readLine();
				// value.matches("(?=.*[0-9]).*");
				valid = true;
				
			} catch (Exception e) {
				System.out.println("Invalid input");
				valid = false;
			}
		} while (!valid);
		
		return value;
		
	}

	static String operation(String leftAsStr, String rightAsStr, String operator) {
		double left = Double.parseDouble(leftAsStr);
		double right = Double.parseDouble(rightAsStr);

		if (operator.equals("+")) {
			return String.valueOf(right+left);
		} else if (operator.equals("-")) {
			return String.valueOf(right-left);
		} else if (operator.equals("*")) {
			return String.valueOf(right *left);
		} else if (operator.equals("/")) {
			return String.valueOf(right/left);
		} else if (operator.equals("^")) {
			return String.valueOf(Math.pow(right, left));
		} else {
			System.err.println("Something wrong ;(");
			return null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "";
		String left = "";
		String right = "";
		while(input != "exit") {
			input = read();
			String[] inputArr = input.split(" ");
			for (int i = 0; i < inputArr.length; i++) {
				if (inputArr[i].matches("[0-9]+")) {
					calStack.push(inputArr[i]);
					System.out.println("Stack: "+calStack.toString());
				} else if (inputArr[i].matches("[+-[*]/^]")) {
					left = calStack.pop();
					right =  calStack.pop();
					calStack.push(operation(left, right, inputArr[i]));
					System.out.println("\nOpera: "+right+(inputArr[i])+left+"\n");
					System.out.println("Stack: "+calStack.toString());
				}
			}


		}
	}

}
