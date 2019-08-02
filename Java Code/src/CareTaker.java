import java.util.ArrayList;
import java.util.List;

/**
 * Contains list that stores results at particular state.
 * 
 * @author Samir
 *
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	/**
	 * Adds state to memento list.
	 * 
	 * @param state Memento state.
	 */
	public void set(Memento state) {
		mementoList.add(state);
	}

	/**
	 * Gets state from memento list.
	 * 
	 * @param index Index to get at.
	 * @return Memento state.
	 */
	public Memento get(int index) {
		return mementoList.get(index);
	}

	/**
	 * Gets list size.
	 * 
	 * @return Memento list size.
	 */
	public int getListSize() {
		return mementoList.size();
	}

	/**
	 * Clears list.
	 */
	public void clearList() {
		mementoList.clear();
	}
}
