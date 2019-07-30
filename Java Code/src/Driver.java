import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

public class Driver {

	static boolean hasSomeInMemory = false;
	static double numberInMemory = 0;
	static boolean hasAnyToStore = false;
	static double result = 0;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int userChoice;
		
		do {
			System.out.println(" =========================== :: CALCULATOR :: ===========================");
			System.out.println("\nSelect use case:\n");
			System.out.println(
					"Press 1 : To calculate the value of the silver ratio number up to certain precision.");
			System.out.println("Press 2 : To calculate an area of a regular octagon with given side length.");
			System.out.println("Press 3 : To evaluate arithmetic expression.");
			System.out.println("Press 4 : To store result in memory for later use.");
			
			System.out.println("Press 0 : To Switch Off");
			displayFromMemory();

			
			userChoice = in.nextInt();
			in.nextLine();

			switch (userChoice) {
			case 1:
				System.out.println("How many digits after decimal point?:");
				int numberofDecimals = in.nextInt();
				BigDecimal resultBigDecimal = calculateSilverRatio(numberofDecimals);
				result = resultBigDecimal.doubleValue();
				hasAnyToStore = true;
				System.out.println("The silver ratio number up to " + numberofDecimals + "precision is: " + result);
				break;

			case 2:
				System.out.println("Enter side length of octagon:");
				int sideLength = in.nextInt();
				System.out.println("The area of a regular octagon with side length " + sideLength + " is: "
						+ areaOfOctagon(sideLength));
				areaOfOctagon(sideLength);
				break;

			case 3:
				System.out.println(
						"Write arithmetic expression: \n Use the character \"S\" for the silver ratio number:");
				String expression = in.nextLine();
				System.out.println("Answer is: " + evaluateArithmeticExpression(expression));
				break;

			case 4:
				storeResultInMemory();
				break;
				
			case 0:
				System.out.print("SWITCHING OFF");
				for (int x = 0; x <= 5; x++) {
					try {
						Thread.sleep(500);
						System.out.print(".");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\nBye.");
				break;

			default:
				System.out.println("\nINVALID CHOICE !!! \nRun again to use the calculator");
				break;
			}
		} while (userChoice != 0);
	}

	private static void storeResultInMemory() {
		if (hasAnyToStore) {
			numberInMemory = result;
			System.out.println(result + " is now stored in memory");
		} else {
			System.out.println("Oops..! There is nothing to store, you can store result if you have done any calculations.");
		}
	}

	private static void displayFromMemory() {
		if (hasSomeInMemory) {
			System.out.println("-----------MEMORY-STATUS---------");
			System.out.println(numberInMemory);
			System.out.println("---------------------------------");
		} else {
			System.out.println("----------MEMORY-STATUS----------");
			System.out.println("NIL");
			System.out.println("---------------------------------");
		}
	}

	private static double evaluateArithmeticExpression(String expression) {
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Double> valuesStack = new Stack<Double>();

		// Stack for Operators: 'ops'
		Stack<Character> operatorStack = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ')
				continue;

			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
					sbuf.append(tokens[i++]);

				valuesStack.push(Double.parseDouble(sbuf.toString()));
			}

			if (i >= tokens.length)
				continue;

			if (tokens[i] == 'S' || tokens[i] == 's')
				valuesStack.push(silverRatio(22));

			// Current token is an opening brace, push it to 'ops'
			if (tokens[i] == '(')
				operatorStack.push(tokens[i]);

			// Closing brace encountered, solve entire brace
			if (tokens[i] == ')') {
				while (operatorStack.peek() != '(')
					valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));
				operatorStack.pop();
			}

			// Current token is an operator.
			if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				// While top of 'ops' has same or greater precedence to current
				// token, which is an operator. Apply operator on top of 'ops'
				// to top two elements in values stack
				while (!operatorStack.empty() && hasPrecedence(tokens[i], operatorStack.peek()))
					valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));

				// Push current token to 'ops'.
				operatorStack.push(tokens[i]);
			}
		}

		// Entire expression has been parsed at this point, apply remaining
		// ops to remaining values
		while (!operatorStack.empty())
			valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));

		// Top of 'values' contains result, return it
		return valuesStack.pop();
	}

	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static double applyOperator(char op, double b, double a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	private static double areaOfOctagon(double sideLength) {
		double silverRatio = silverRatio(22);
		return (2 * (silverRatio)) * (sideLength * sideLength);
	}

	private static BigDecimal calculateSilverRatio(int numberofDecimals) {
		double silverRatio = silverRatio(22);
		return truncateDecimal(silverRatio, numberofDecimals);
	}

	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}
	
	// Calculates the value of the silver ratio number
	public static double silverRatio(int n) {
		if (n == 0)
			return 1;
		return 2.0 + 1.0 / silverRatio(n - 1);
	}
}
