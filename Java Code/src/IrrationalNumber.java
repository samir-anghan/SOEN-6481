/**
 * Interface for irrational number
 * @author Samir
 *
 */
public interface IrrationalNumber {
	/**
	 * Computes value of irrational number
	 */
	public void computeValue();
	
	/**
	 * Computes the  value  of  the irrational number up to given certain decimal places
	 * @param numberofDecimals Decimal places
	 */
	public void computeValueUptoPrecision(int numberofDecimals);
}
