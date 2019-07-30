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
		
		IrrationalNumber silverRatio = new SilverRatioNumber();
		AreaOfRegularOctagonExpression regularOctagonExpression = new AreaOfRegularOctagonExpression();
		Display display = new Display();
		
		Scanner in = new Scanner(System.in);
		int userChoice;
		double result = 0;
		
		System.out.println("** The Irrational Number Calculator **\n");
		display.displayResult(result);
		do {
			
			System.out.println("#");
			System.out.println(
					"# Press 1 : To calculate the value of the silver ratio number up to certain precision.");
			System.out.println("# Press 2 : To calculate an area of a regular octagon with given side length.");
			System.out.println("# Press 3 : To evaluate arithmetic expression.");
			System.out.println("# Press 4 : To store result in memory for later use.");
			System.out.println("# Press 0 : To Switch Off.");
			System.out.println("#");

			userChoice = in.nextInt();
			in.nextLine();

			switch (userChoice) {
			case 1:
				System.out.println("*?");
				System.out.println("*? How many digits do you want after decimal point?");
				System.out.println("*?");
				int numberofDecimals = in.nextInt();
				try {
					result = silverRatio.computeValueUptoPrecision(numberofDecimals);
					display.displayResult(result);
				} catch (Exception e1) {
					display.displayResult("ERROR");
					display.printError("Maximum 15 digits can be shown after decimal point! Try again with smaller number than 15.");
				}
				break;

			case 2:
				System.out.println("*?");
				System.out.println("*? Please enter side length of octagon:");
				System.out.println("*?");
				int sideLength = in.nextInt();
				result = regularOctagonExpression.computeAreaOfRegularOctagon(sideLength);
				display.displayResult(result);
				break;

			case 3:
				break;

			case 4:
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

}
