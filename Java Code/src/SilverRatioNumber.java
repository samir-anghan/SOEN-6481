/**
 * 
 */

/**
 * @author Samir
 *
 */
public class SilverRatioNumber implements IrrationalNumber {

	private double silverRatioValue;

	@Override
	public void computeValue() {
		double silverRatioValue = computeSilverRatio(22);
		setSilverRatioValue(silverRatioValue);
	}
	
	@Override
	public double computeValueUptoPrecision(int numberofDecimals) {
		computeValue();
		String silverRatioAsString = String.valueOf(silverRatioValue);
		String truncatedString = silverRatioAsString.substring(0, numberofDecimals + 2);
		double truncatedSilverRatioValue = Double.parseDouble(truncatedString);
		return truncatedSilverRatioValue;
	}
	
	private double computeSilverRatio(int n) {
		if (n == 0)
			return 1;
		return 2.0 + 1.0 / computeSilverRatio(n - 1);
	}
	
	/**
	 * @return the value
	 */
	public double getSilverRatioValue() {
		return silverRatioValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setSilverRatioValue(double value) {
		this.silverRatioValue = value;
	}
}
