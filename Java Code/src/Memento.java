/**
 * Restores an object to its previous state.
 * 
 * @author Samir
 *
 */
public class Memento {
	private double result;

	/**
	 * Constructor.
	 * 
	 * @param result Expression result.
	 */
	public Memento(double result) {
		this.result = result;
	}

	/**
	 * Gets expression result.
	 * 
	 * @return Expression result.
	 */
	public double getResult() {
		return result;
	}
}
