import java.util.Scanner;
import java.util.Stack;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("=============== :: CALCULATOR :: ===============");
		System.out.println("\nSelect use case:\n");
		System.out.println("Press 1 : To calculate the value of the silver ratio number up to given certain decimal places.");
		System.out.println("Press 2 : To calculate an area of a regular octagon with given side length");
		System.out.println("Press 3 : To evaluate arithmatic expression:");
		System.out.println("Press 4 : To subtract a certain number from the value of the silver ratio number:");
		System.out.println("Press 5 : To multiply a certain number with the value of the silver ratio number");
		System.out.println("Press 6 : To divide a certain number by the value of the silver ratio number");
		System.out.println("Press 7 : To divide the value of the silver ratio number by a certain number,");
		
		int userChoice = in.nextInt();
		in.nextLine();
		
		switch (userChoice) {
		case 1:
			calculateSilverRatio();
			break;
			
		case 2:
			System.out.println("Enter side length of octagon:");
			int sideLength = in.nextInt();
			System.out.println("The area of a regular octagon with side length " + sideLength + " is: " + areaOfOctagon(sideLength));
			areaOfOctagon(sideLength);
			break;
		
		case 3:
			System.out.println("Write arithmetic expression: \n Use character \"S\" if you want to use the silver ratio number:");
			String expression = in.nextLine();
			System.out.println("Answer is: " + evaluateArithmeticExpression(expression));
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

	private static double evaluateArithmeticExpression(String expression) {
		char[] tokens = expression.toCharArray();
		  
        // Stack for numbers: 'values' 
       Stack<Double> values = new Stack<Double>();
 
       // Stack for Operators: 'ops' 
       Stack<Character> ops = new Stack<Character>(); 
 
       for (int i = 0; i < tokens.length; i++) 
       { 
            // Current token is a whitespace, skip it 
           if (tokens[i] == ' ') 
               continue; 
 
           // Current token is a number, push it to stack for numbers 
           if (tokens[i] >= '0' && tokens[i] <= '9') 
           { 
               StringBuffer sbuf = new StringBuffer(); 
               // There may be more than one digits in number
               while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
                   sbuf.append(tokens[i++]);

               values.push(Double.parseDouble(sbuf.toString()));
           }

           if (i >= tokens.length)
               continue;

           if (tokens[i] == 'S' || tokens[i] == 's')
               values.push(silverRatio(22));
 
           // Current token is an opening brace, push it to 'ops' 
           if (tokens[i] == '(')
               ops.push(tokens[i]);
 
           // Closing brace encountered, solve entire brace 
           if (tokens[i] == ')')
           { 
               while (ops.peek() != '(') 
                 values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
               ops.pop(); 
           } 
 
           // Current token is an operator. 
           if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') 
           { 
               // While top of 'ops' has same or greater precedence to current 
               // token, which is an operator. Apply operator on top of 'ops' 
               // to top two elements in values stack 
               while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                 values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
 
               // Push current token to 'ops'. 
               ops.push(tokens[i]); 
           } 
       } 
 
       // Entire expression has been parsed at this point, apply remaining 
       // ops to remaining values 
       while (!ops.empty()) 
           values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
 
       // Top of 'values' contains result, return it 
       return values.pop(); 
	}

	// Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
  
    // A utility method to apply an operator 'op' on operands 'a'  
    // and 'b'. Return the result. 
    public static double applyOp(char op, double b, double a)
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        } 
        return 0; 
    } 
    
	private static double areaOfOctagon(double sideLength) {
		double silverRatio = silverRatio(22);
		return (2 * (silverRatio)) * (sideLength * sideLength);	
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
