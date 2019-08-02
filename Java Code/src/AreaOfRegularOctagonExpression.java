/**
 * 
 */

/**
 * @author Samir
 *
 */
public class AreaOfRegularOctagonExpression extends Expression {

	SilverRatioNumber silverRatio = new SilverRatioNumber();

	/**
	 * Calculates an area of a regular octagon with given side length.
	 * 
	 * @param sideLength side length of a regular octagon.
	 */
	public void computeAreaOfRegularOctagon(double sideLength) {
		double silverRatioNumber = silverRatio.getSilverRatioValue();
		result = (2 * (silverRatioNumber)) * (sideLength * sideLength);
	}
}
