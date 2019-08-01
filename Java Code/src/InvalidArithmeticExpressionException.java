/**
 * Custom exception handle invalid arithmetic expression exception
 * @author Samir
 *
 */
public class InvalidArithmeticExpressionException extends RuntimeException{
	
	public InvalidArithmeticExpressionException(String errorMessage) {
        super(errorMessage);
    }
}
