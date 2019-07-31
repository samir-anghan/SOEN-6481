import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Samir
 *
 */
public class Calculator {

	public static void main(String[] args) {
		
		SilverRatioNumber silverRatio = new SilverRatioNumber();
		AreaOfRegularOctagonExpression regularOctagonExpression = new AreaOfRegularOctagonExpression();
		ArithmaticExpression arithmaticExpression = new ArithmaticExpression();
		CareTaker careTaker = new CareTaker();
		Display display = new Display();
		CurrentOperation currentOperation = CurrentOperation.None;
		
		Scanner in = new Scanner(System.in);
		int userChoice;
		double result = 0;
		
		
		System.out.println("** The Irrational Number Calculator **\n");
		display.displayResult(result);
		do {
			System.out.println("#");
			
			System.out.println("# Basic Functions:");
			System.out.println("# -----------------");
			System.out.println("# Press 1: To evaluate an arithmetic expression.");
			System.out.println("#");
			System.out.println("#");
			
			System.out.println("# Silver Ratio Number Functions:");
			System.out.println("# --------------------------------");
			System.out.println(
					"# Press 2: To calculate the value of the silver ratio number up to certain precision.");
			System.out.println("#");
			System.out.println("#");
			
			System.out.println("# Silver Ratio Number Application Functions:");
			System.out.println("# -------------------------------------------");
			System.out.println("# Press 3: To calculate an area of a regular octagon with given side length.");
			System.out.println("#");
			System.out.println("#");
			
			System.out.println("# Memory Functions:");
			System.out.println("# ------------------");
			System.out.println("# Press 4: To store the displayed value to the memory for later use.");
			System.out.println("# Press 5: To recall the value stored in memory.");
			System.out.println("# Press 6: To clear the memory.");
			System.out.println("#");
			System.out.println("#");
			
			System.out.println("# Other:");
			System.out.println("# -------");
			System.out.println("# Press 0: To Switch Off.");
			System.out.println("#");

			userChoice = in.nextInt();
			in.nextLine();

			switch (userChoice) {
			case 1:
				System.out.println("*?");
				System.out.println("*? Keys:");
				System.out.println("*? Letter \"S\": Use the letter \"S\" in your expression for the silver ratio number, if you want to use the silver ratio number.");
				System.out.println("*? Please write your arithmetic expression:");
				System.out.println("*?");
				String expression = in.nextLine();
				try {
					arithmaticExpression.evaluate(expression);
					result = arithmaticExpression.getResult();
					display.displayResult(result);
				} catch (Exception e1) {
					display.displayResult("ERROR");
					result = 0;
					display.printError("Not a valid arithmetic expression! Try again using valid arithmetic expression.");
				}
				currentOperation = CurrentOperation.ArithmeticExpression;
				break;

			case 2:
				System.out.println("*?");
				System.out.println("*? How many digits do you want after decimal point?");
				System.out.println("*?");
				int numberofDecimals = in.nextInt();
				try {
					silverRatio.computeValueUptoPrecision(numberofDecimals);
					result = silverRatio.getResult();
					display.displayResult(result);
				} catch (Exception e1) {
					display.displayResult("ERROR");
					result = 0;
					display.printError("Maximum 15 digits can be shown after decimal point! Try again using smaller number than 15.");
				}
				currentOperation = CurrentOperation.ComputeSilverRatio;
				break;
				
			case 3:
				System.out.println("*?");
				System.out.println("*? Please enter side length of octagon:");
				System.out.println("*?");
				int sideLength = in.nextInt();
				regularOctagonExpression.computeAreaOfRegularOctagon(sideLength);
				result = regularOctagonExpression.getResult();
				display.displayResult(result);
				currentOperation = CurrentOperation.AreaOfOctagon;
				break;

			case 4:
				switch (currentOperation) {
				case ArithmeticExpression:
					careTaker.set(arithmaticExpression.saveResultToMemento());
					break;
					
				case AreaOfOctagon:
					careTaker.set(regularOctagonExpression.saveResultToMemento());
					break;
					
				case ComputeSilverRatio:
					careTaker.set(silverRatio.saveResultToMemento());
					break;

				default:
					break;
				}
				break;
			
			case 5:
				int index = careTaker.getListSize() - 1;
				switch (currentOperation) {
				case ArithmeticExpression:
					arithmaticExpression.restoreResultFromMemento(careTaker.get(index));
					result = arithmaticExpression.getResult();
					display.displayResult(result);
					break;
					
				case AreaOfOctagon:
					regularOctagonExpression.restoreResultFromMemento(careTaker.get(index));
					result = regularOctagonExpression.getResult();
					display.displayResult(result);
					break;
					
				case ComputeSilverRatio:
					silverRatio.restoreResultFromMemento(careTaker.get(index));
					result = silverRatio.getResult();
					display.displayResult(result);
					break;

				default:
					break;
				}
				break;
				
			case 0:
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
				System.out.println("\nINVALID CHOICE !!! \nRun again to use the calculator");
				break;
			}
		} while (userChoice != 0);
	}

	enum CurrentOperation {
		None,
		ArithmeticExpression,
		ComputeSilverRatio,
		AreaOfOctagon;
	}

}
