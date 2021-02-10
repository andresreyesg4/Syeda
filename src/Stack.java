/**
 * The stack interface, is used to define the methods that will be overridden by another classs.
 *
 * @param <T> holds the generic value of the data which it is used by.
 */
// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------
interface Stack<T> {
	/**
	 * This method will push(add) an item to the top of the stack.
	 * @param value holds the element to be added.
	 * @return true if adding was successful, false otherwise.
	 */
	public boolean push(T value);

	/**
	 * pop() method will remove the item in the top of the list.
	 * Conceptually, this acts as a stack of books.
	 * the last item added will be the first one to be removed.
	 * @return The item removed from the top.
	 */
	public T pop(); //throw NoSuchElementException if nothing to pop

	/**
	 * This method returns the current size of the stack.
	 * Gets updated every time there is a removal or an addition.
	 * @return the size of the stack.
	 */
	public int size();

	/**
	 * Checks if the stack is currently emtpy.
	 *
	 * @return true if its empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * This method clears the whole stack no matter the size of the stack.
	 */
	public void clear();
}