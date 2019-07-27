import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("=============== :: CALCULATOR :: ===============");
		System.out.println("\nSelect use case:\n");
		System.out.println("Press 1 : To calculate the value of the silver ratio number up to given certain decimal places.");
		System.out.println("Press 2 : To calculate an area of a regular octagon with given side length");
		System.out.println("Press 3 : To add a certain number to the value of the silver ratio number:");
		System.out.println("Press 4 : To subtract a certain number from the value of the silver ratio number:");
		System.out.println("Press 5 : To multiply a certain number with the value of the silver ratio number");
		System.out.println("Press 6 : To divide a certain number by the value of the silver ratio number");
		System.out.println("Press 7 : To divide the value of the silver ratio number by a certain number,");
		
		int userChoice = in.nextInt();
		
		switch (userChoice) {
		case 1:
			calculateSilverRatio();
			break;
			
		case 2:
			break;
		
		case 3:
			break;
			
		case 4:
			break;
			
		case 5:
			break;
			
		case 6:
			break;
			
		case 7:
			break;
			
		default:
			System.out.println("\nINVALID CHOICE !!! \nRun again to use the library management system.");
			break;
		}

	}

	private static void calculateSilverRatio() {
		System.out.println(silverRatio(22));
	}
	
	// Calculates the value of the silver ratio number
	public static double silverRatio(int n) {
        if (n == 0) return 1;
        return 2.0 + 1.0 / silverRatio(n-1);
    }
	
}
