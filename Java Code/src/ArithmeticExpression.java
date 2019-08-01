import java.util.Stack;

/**
 * Arithmetic Expression
 * 
 * @author Samir
 */
public class ArithmeticExpression extends Expression {

	SilverRatioNumber silverRatio = new SilverRatioNumber();

	/**
	 * Evaluates arithmetic expression.
	 * 
	 * @param expression Expression to evaluate.
	 */
	public void evaluate(String expression) {

		validate(expression);

		char[] tokens = expression.toCharArray();
		Stack<Double> valuesStack = new Stack<Double>();
		Stack<Character> operatorStack = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;

			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();

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

			if (tokens[i] == '(')
				operatorStack.push(tokens[i]);

			if (tokens[i] == ')') {
				while (operatorStack.peek() != '(')
					valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));
				operatorStack.pop();
			}

			if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!operatorStack.empty() && hasPrecedence(tokens[i], operatorStack.peek()))
					valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));

				operatorStack.push(tokens[i]);
			}
		}

		while (!operatorStack.empty())
			valuesStack.push(applyOperator(operatorStack.pop(), valuesStack.pop(), valuesStack.pop()));

		result = valuesStack.pop();
	}

	/**
	 * Returns true if 'operator2' has higher or same precedence as 'operator1',
	 * otherwise returns false.
	 * 
	 * @param operator1 Operator
	 * @param operator2 Operator
	 * @return
	 */
	private boolean hasPrecedence(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')')
			return false;
		if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
			return false;
		else
			return true;
	}

	/**
	 * Apply an operator 'op' on operands 'a' and 'b'.
	 * 
	 * @param op Operator
	 * @param b  Operand
	 * @param a  Operand
	 * @return The result.
	 */
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

	/**
	 * Validates an expression.
	 * 
	 * @param expression Expression to validate.
	 */
	private void validate(String expression) {
		char[] tokens = expression.toCharArray();

		for (int i = 0; i < tokens.length; i++) {
			char ch = tokens[i];

			boolean isValid = Character.isDigit(ch) || ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '('
					|| ch == ')' || ch == ' ' || ch == 's' || ch == 'S' || ch == '.';

			if (isValid == false) {
				throw new InvalidArithmeticExpressionException("Invalid Arithmetic Expression");
			}
		}
	}
}
