import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Samir
 *
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	   public void set(Memento state){
	      mementoList.add(state);
	   }

	   public Memento get(int index){
	      return mementoList.get(index);
	   }
	   
	   public int getListSize() {
		   return mementoList.size();
	   }
}
