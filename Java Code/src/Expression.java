public class Expression {

	protected double result;

	/**
	 * Gets expression result.
	 * 
	 * @return An expression result.
	 */
	public double getResult() {
		return result;
	}

	/**
	 * Sets expression result.
	 * 
	 * @param result An expression result.
	 */
	public void setResult(double result) {
		this.result = result;
	}

	/**
	 * Saves result to memento.
	 * 
	 * @return Result.
	 */
	public Memento saveResultToMemento() {
		return new Memento(result);
	}

	/**
	 * Restores result from memento.
	 * 
	 * @param memento Memento to restore.
	 */
	public void restoreResultFromMemento(Memento memento) {
		result = memento.getResult();
	}
}
