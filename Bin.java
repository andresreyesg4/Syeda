import java.util.NoSuchElementException;

/**
 * Bin class implements the Stack interface, overriding all its signature methods.
 * As a generic value there is a Plate value which is used throughout the bin class.
 * The stack will be implemented using an AttachedList.
 */
public class Bin implements Stack<Plate> {
	//this is your internal storage
	/**
	 * Used as internal storage for the Bin which is a stack.
	 */
	public AttachedList<Plate> internalList;
	
	//you may _NOT_ add any additional instance variables, use the list above!
	//you should not need any additional private helper methods, but you
	//may add them if you like

	/**
	 * Constructor for Bin class.
	 * Initializes the internalList.
	 */
	public Bin() {
		//any initialization goes here
		this.internalList = new AttachedList<>();
	}
	
	//override all the required methods
	//all methods must be O(1)
	//all methods can be written in 3 lines or less of code
	//if you're writing much more than that, something is probably wrong...


	/**
	 * Adds an element to the stack.
	 * All elements must be added to the top.
	 * In this case the end of the list.
	 * @param value holds the plate to be added.
	 * @return if the push was successful or not.
	 */
	@Override
	public boolean push(Plate value) {
		boolean successful = value != null;
		if(successful){ internalList.add(0,value);}
		return successful;
	}

	/**
	 * This method removes the last item added which is the end of list.
	 * Or can be seen as the top of the stack.
	 * @return the item removed from the stack.
	 */
	@Override
	public Plate pop() {
		if(internalList.isEmpty()){throw new NoSuchElementException();}
		else{ return internalList.remove(0);}
	}

	/**
	 * Gets the size of the stack.
	 *
	 * @return the size of the stack.
	 */
	@Override
	public int size() {
		return internalList.size();
	}

	/**
	 * Checks if the stack is empty.
	 *
	 * @return false if stack not empty, true otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	/**
	 * clears the stack empty.
	 * With it also the size is set to 0.
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
		Bin bin = new Bin();
		int i = 0;
		bin.push(new Plate(1));
		bin.push(new Plate(2));
		bin.push(new Plate(3));
		bin.push(new Plate(4));
		//System.out.println(bin.internalList.toString());
		//System.out.println(bin.pop());
		//while(i < 5){
		//	bin.push(new Plate(i));
		//	i++;
		//}
		System.out.println(bin.toString());
	}

	/**
	 * The toString() method for Bin class, uses an enhanced for each loop to save the items int the bin to a string.
	 * Once the loop is complete, the method returns the finished String with all the elements.
	 * @return the stack in string form.
	 */
	// --------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
	// --------------------------------------------------------
	public String toString() {
		String returnString = "";
		boolean first = true;
		for(Plate p : internalList) {
			if(first) { returnString = returnString+p; first = false; }
			else {returnString = returnString+"|"+p; }
		}
		return returnString;
	}

}
