/**
 * Restores an object to its previous state
 * @author Samir
 *
 */
public class Memento {
	private double result;

	   public Memento(double result){
	      this.result = result;
	   }

	   public double getResult(){
	      return result;
	   }	
}
