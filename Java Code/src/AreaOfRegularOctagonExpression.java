/**
 * 
 */

/**
 * @author Samir
 *
 */
public class AreaOfRegularOctagonExpression {
	
	private double result;
	
	SilverRatioNumber silverRatio = new SilverRatioNumber();
	
	public void computeAreaOfRegularOctagon(double sideLength) {
		double silverRatioNumber = silverRatio.getSilverRatioValue();
		result = (2 * (silverRatioNumber)) * (sideLength * sideLength);
	}
	
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	public Memento saveResultToMemento() {
	      return new Memento(result);
	}
}
