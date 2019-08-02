import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		SilverRatioNumber silverRatio = new SilverRatioNumber();
		AreaOfRegularOctagonExpression regularOctagonExpression = new AreaOfRegularOctagonExpression();
		ArithmeticExpression arithmeticExpression = new ArithmeticExpression();
		CareTaker careTaker = new CareTaker();
		Display display = new Display();
		CurrentOperation currentOperation = CurrentOperation.None;

		String userChoice;
		double result = 0;

		System.out.println("** The Irrational Number Calculator **\n");

		do {
			display.displayResult(result);
			if (careTaker.getListSize() > 0)
				display.displayMemoryIndicator();

			displayChoices();
			Scanner in = new Scanner(System.in);
			userChoice = in.nextLine();

			switch (userChoice) {
			case "1":
				System.out.println("*?");
				System.out.println(
						"*? Use the letter \"S\" in your expression for the silver ratio number,");
				System.out.println("*? if you want to use the silver ratio number in your expression.");
				System.out.println("*?");
				System.out.println("*? Please write your arithmetic expression:");
			
				String expression = in.nextLine();
				try {
					arithmeticExpression.evaluate(expression);
					result = arithmeticExpression.getResult();
				} catch (Exception e1) {
					display.displayResult("ERROR");
					result = 0;
					display.printError(
							"Not a valid arithmetic expression! Try again using valid arithmetic expression.");
				}
				currentOperation = CurrentOperation.ArithmeticExpression;
				break;

			case "2":
				System.out.println("*?");
				System.out.println("*? How many digits do you want after decimal point?:");
				System.out.println("*?");
				int numberofDecimals = in.nextInt();
				try {
					silverRatio.computeValueUptoPrecision(numberofDecimals);
					result = silverRatio.getResult();
				} catch (Exception e1) {
					display.displayResult("ERROR");
					result = 0;
					display.printError(
							"Maximum 15 digits can be shown after decimal point! Try again using smaller number than 15.");
				}
				currentOperation = CurrentOperation.ComputeSilverRatio;
				break;

			case "3":
				System.out.println("*?");
				System.out.println("*? Please enter side length of octagon:");
				System.out.println("*?");
				int sideLength = in.nextInt();
				regularOctagonExpression.computeAreaOfRegularOctagon(sideLength);
				result = regularOctagonExpression.getResult();
				currentOperation = CurrentOperation.AreaOfOctagon;
				break;

			case "4":
				switch (currentOperation) {
				case ArithmeticExpression:
					careTaker.set(arithmeticExpression.saveResultToMemento());
					display.printFeedback("Result has been stored in memory for later use.");
					break;

				case AreaOfOctagon:
					careTaker.set(regularOctagonExpression.saveResultToMemento());
					display.printFeedback("Result has been stored in memory for later use.");
					break;

				case ComputeSilverRatio:
					careTaker.set(silverRatio.saveResultToMemento());
					display.printFeedback("Result has been stored in memory for later use.");
					break;

				case None:
					display.displayResult("ERROR");
					display.printError("There is nothing to store! Please try again.");

				default:
					break;
				}
				break;

			case "5":
				int index = careTaker.getListSize() - 1;
				switch (currentOperation) {
				case ArithmeticExpression:
					arithmeticExpression.restoreResultFromMemento(careTaker.get(index));
					result = arithmeticExpression.getResult();
					display.printFeedback("Result has been restored from memory.");
					break;

				case AreaOfOctagon:
					regularOctagonExpression.restoreResultFromMemento(careTaker.get(index));
					display.printFeedback("Result has been restored from memory.");
					result = regularOctagonExpression.getResult();
					
					break;

				case ComputeSilverRatio:
					silverRatio.restoreResultFromMemento(careTaker.get(index));
					display.printFeedback("Result has been restored from memory.");
					result = silverRatio.getResult();
					
					break;

				case None:
					display.displayResult("ERROR");
					display.printError("There is nothing to restore from memory.");

				default:
					break;
				}
				break;
				
			case "6":
				careTaker.clearList();
				display.printFeedback("Memory is clear now.");
				break;

			case "0":
				System.out.print("SWITCHING OFF");
				for (int x = 0; x <= 2; x++) {
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
				display.printError("Invalid choice! Please supply valid choice input.");
				break;
			}
		} while (userChoice != "0");
	}

	private static void displayChoices() {
		System.out.println("# Basic Functions:");
		System.out.println("# -----------------");
		System.out.println("# Press 1: To evaluate an arithmetic expression.");
		System.out.println("#");

		System.out.println("# Silver Ratio Number Functions:");
		System.out.println("# --------------------------------");
		System.out.println("# Press 2: To calculate the value of the silver ratio number up to certain precision.");
		System.out.println("#");

		System.out.println("# Silver Ratio Number Application Functions:");
		System.out.println("# -------------------------------------------");
		System.out.println("# Press 3: To calculate an area of a regular octagon with given side length.");
		System.out.println("#");

		System.out.println("# Memory Functions:");
		System.out.println("# ------------------");
		System.out.println("# Press 4: To store the displayed value to the memory for later use.");
		System.out.println("# Press 5: To recall the value stored in memory.");
		System.out.println("# Press 6: To clear the memory.");
		System.out.println("#");

		System.out.println("# Other:");
		System.out.println("# -------");
		System.out.println("# Press 0: To Switch Off.");
		System.out.println("#");
		System.out.println("# Please enter your choice:");
	}

	/**
	 * Holds current operation.
	 */
	enum CurrentOperation {
		None, ArithmeticExpression, ComputeSilverRatio, AreaOfOctagon;
	}
}
