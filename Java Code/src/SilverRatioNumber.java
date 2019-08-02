public class SilverRatioNumber extends Expression implements IrrationalNumber {

	private double silverRatioValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see IrrationalNumber#computeValue()
	 */
	@Override
	public void computeValue() {
		double silverRatioValue = computeSilverRatio(22);
		setSilverRatioValue(silverRatioValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IrrationalNumber#computeValueUptoPrecision(int)
	 */
	@Override
	public void computeValueUptoPrecision(int numberofDecimals) {
		computeValue();
		String silverRatioAsString = String.valueOf(silverRatioValue);
		String truncatedString = silverRatioAsString.substring(0, numberofDecimals + 2);
		double truncatedSilverRatioValue = Double.parseDouble(truncatedString);
		result = truncatedSilverRatioValue;
	}

	/**
	 * Computes value of the silver ratio number.
	 * 
	 * @param n Number of iteration.
	 * @return
	 */
	private double computeSilverRatio(int n) {
		if (n == 0)
			return 1;
		return 2.0 + 1.0 / computeSilverRatio(n - 1);
	}

	/**
	 * Get value of silver ratio number.
	 * 
	 * @return the value Silver ratio number.
	 */
	public double getSilverRatioValue() {
		computeValue();
		return silverRatioValue;
	}

	/**
	 * Sets value of silver ratio number.
	 * 
	 * @param value The value to set.
	 */
	public void setSilverRatioValue(double value) {
		this.silverRatioValue = value;
	}
}
