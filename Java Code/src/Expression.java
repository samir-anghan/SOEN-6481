/**
 * 
 */

/**
 * @author Samir
 *
 */
public class Expression {

	protected double result;

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public Memento saveResultToMemento() {
		return new Memento(result);
	}

	public void restoreResultFromMemento(Memento memento) {
		result = memento.getResult();
	}
}
