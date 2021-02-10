import java.util.NoSuchElementException;

/**
 * Air class implements the Queue interface with all the signature methods.
 * This case the Air will hold a Plate value.
 * It will be implemented using an AttachedList.
 */
public class Air implements Queue<Plate> {
	//Maximum allowed items in the air... don't allow more than this!
	/**
	 * Constant maximum capacity.
	 */
	public static final int MAX_CAPACITY = 13;
	
	//this is your internal storage
	/**
	 * acts as the internal storacge for the queue.
	 */
	public AttachedList<Plate> internalList;
	
	//you may _NOT_ add any additional instance variables, use the list above!
	//you should not need any additional private helper methods, but you
	//may add them if you like

	/**
	 * Default constructor which initializes the internal storage for the stack.
	 */
	public Air() {
		//any initialization goes here
		this.internalList = new AttachedList<>();
	}
	
	//override all the required methods
	//all methods must be O(1)
	//all methods can be written in 3 lines or less of code
	//if you're writing much more than that, something is probably wrong...

	/**
	 * Adds an element in the queue.
	 * In this case the element will always be added at the end of the queue.
	 * It will only be added if the size is <= MAX_CAPACITY (13).
	 *
	 * @param value holds the value to be added.
	 * @return whether it was successfully added or not.
	 */
	@Override
	public boolean enqueue(Plate value) {
		if(internalList.size() < MAX_CAPACITY) {
			return internalList.add(value); //keeps on adding to the end of the queue.
		}else{ return false;}
	}

	/**
	 * Removes the front of the queue.
	 * Because a queue acts as First in First out.
     * Throws a NoSuchElementException if there is nothing to dequeue.
	 * @return The plate that was removed.
	 */
	@Override
	public Plate dequeue() {
		if(internalList.isEmpty()) {throw new NoSuchElementException();}
	    else{return internalList.remove(0); }
	}

	/**
	 * Gets the size of the queue.
	 * @return the size of the current queue.
	 */
	@Override
	public int size() {
		return internalList.size(); //returns the size of the queue.
	}

	/**
	 * Checks if the queue is empty, by calling the isEmpty() method from internalList.
	 *
	 * @return false if the queue is not empty, true otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	/**
	 * Clears the current stack.
	 * the size is set to 0.
	 */
	@Override
	public void clear() {
		internalList.clear();
	}

	/**
	 * Used for testing only.
	 * @param args command line arguments.
	 */
	// --------------------------------------------------------
	// testing code goes here... edit this as much as you want!
	// --------------------------------------------------------
	public static void main(String[] args) {
		Air air = new Air();
		for(int i = 0; i <= 13; i++){
			air.enqueue(new Plate(i));
		}
		//air.enqueue(new Plate(1));
		//air.internalList.add(new Plate(2));
		System.out.println(air.internalList.toString());
		System.out.println(air.toString());

	}

	/**
	 * Override the super class toString method, which turns all the elements in air into a string.
	 * The string is returned.
	 * @return elements in string form.
	 */
	// --------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
	// --------------------------------------------------------
	public String toString() {
		String returnString = "";
		for(Plate p : internalList) {
			returnString = p+returnString;
		}
		return returnString;
	}


}
