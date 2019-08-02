/**
 * Custom exception handle invalid arithmetic expression exception
 * 
 * @author Samir
 *
 */
public class InvalidArithmeticExpressionException extends RuntimeException {

	/**
	 * Constructor.
	 * 
	 * @param errorMessage Error message to throw.
	 */
	public InvalidArithmeticExpressionException(String errorMessage) {
		super(errorMessage);
	}
}