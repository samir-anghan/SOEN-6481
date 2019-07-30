/**
 * 
 */

/**
 * @author Samir
 *
 */
public class AreaOfRegularOctagonExpression {
	
	SilverRatioNumber silverRatio = new SilverRatioNumber();
	
	public double computeAreaOfRegularOctagon(double sideLength) {
		silverRatio.computeValue();
		double silverRatioNumber = silverRatio.getSilverRatioValue();
		return (2 * (silverRatioNumber)) * (sideLength * sideLength);
	}
}
