/**
 * To display results.
 * 
 * @author Samir
 *
 */
public class Display {
	/**
	 * Displays result on screen.
	 * 
	 * @param result Result to display.
	 */
	public void displayResult(double result) {
		System.out.println("\n---------RESULT DISPLAY---------");
		if (result == 0.0)
			System.out.println("0");
		else
			System.out.println(result);
		System.out.println("--------------------------------\n");
	}

	/**
	 * Displays result on screen.
	 * 
	 * @param error Result to display.
	 */
	public void displayResult(String error) {
		System.out.println("\n---------RESULT DISPLAY---------");
		System.out.println(error);
		System.out.println("--------------------------------\n");
	}

	/**
	 * Prints given error on screen.
	 * 
	 * @param error Error to print.
	 */
	public void printError(String error) {
		System.out.println("*!");
		System.out.println("*! ERROR DISCRIPTION: " + error);
		System.out.println("*!\n");
	}
}
