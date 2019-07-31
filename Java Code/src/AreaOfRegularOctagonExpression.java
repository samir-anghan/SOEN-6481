/**
 * 
 */

/**
 * @author Samir
 *
 */
public class AreaOfRegularOctagonExpression extends Expression{
	
	SilverRatioNumber silverRatio = new SilverRatioNumber();
	
	public void computeAreaOfRegularOctagon(double sideLength) {
		double silverRatioNumber = silverRatio.getSilverRatioValue();
		result = (2 * (silverRatioNumber)) * (sideLength * sideLength);
	}
	
	
}
