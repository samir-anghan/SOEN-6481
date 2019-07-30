import java.util.Stack;

/**
 * 
 */

/**
 * @author Samir
 *
 */
public class ArithmaticExpression {

	SilverRatioNumber silverRatio = new SilverRatioNumber();

	public double evaluate(String expression) {
		
		validate(expression);
		
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

			if (tokens[i] == 'S' || tokens[i] == 's') {
				double silverRatioNumber = silverRatio.getSilverRatioValue();
				valuesStack.push(silverRatioNumber);
			}

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
	private boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A utility method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	private double applyOperator(char op, double b, double a) {
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

	private void validate(String expression) {
		char[] tokens = expression.toCharArray();

		for (int i = 0; i < tokens.length; i++) {
			char ch = tokens[i];

			boolean isValid = Character.isDigit(ch) || ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '('
					|| ch == ')' || ch == ' ' || ch == 's' || ch == 'S';

			if (isValid == false) {
				throw new InvalidArithmeticExpressionException("Invalid Arithmetic Expression");
			}
		}
	}
}
