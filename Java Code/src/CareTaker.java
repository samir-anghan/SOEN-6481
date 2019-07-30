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

	   public void saveToMemento(Memento state){
	      mementoList.add(state);
	   }

	   public Memento restoreFromMemento(int index){
	      return mementoList.get(index);
	   }
}
