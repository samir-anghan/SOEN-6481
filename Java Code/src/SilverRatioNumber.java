/**
 * Holds value of Silver Ratio Number.
 * @author Samir
 */
public class SilverRatioNumber extends Expression implements IrrationalNumber  {

	private double silverRatioValue;

	@Override
	public void computeValue() {
		double silverRatioValue = computeSilverRatio(22);
		setSilverRatioValue(silverRatioValue);
	}
	
	@Override
	public void computeValueUptoPrecision(int numberofDecimals) {
		computeValue();
		String silverRatioAsString = String.valueOf(silverRatioValue);
		String truncatedString = silverRatioAsString.substring(0, numberofDecimals + 2);
		double truncatedSilverRatioValue = Double.parseDouble(truncatedString);
		result = truncatedSilverRatioValue;
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
		computeValue();
		return silverRatioValue;
	}

	/**
	 * @param value the value to set
	 */
	public void setSilverRatioValue(double value) {
		this.silverRatioValue = value;
	}
}
