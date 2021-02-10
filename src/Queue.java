/**
 * The Queue interface is used to override the methods from the class provided by the java.lang.
 * Each method is written as a statement with a ; at the end.
 * It is only a definition of the methods that will be overridden.
 * @param <T> holds the generic value for the queue.
 */
// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------
interface Queue<T> {
	/**
	 * this method will be used to enqueue (add) an element at the front of the queue.
	 * @param value holds the element to be added.
	 * @return true if enqueuing is successful or not.
	 */
	public boolean enqueue(T value);

	/**
	 * dequeue() will remove the item that was added last.
	 * Conceptually the queue is like a line in super market.
	 * The person in front gets to be attended first.
	 * @return The item which is removed.
	 */
	public T dequeue(); //throw NoSuchElementException if nothing to dequeue

	/**
	 * the size() method will return the current value of the size instance.
	 * The size instance is updated every time an item is added to the queue.
	 * Also if there is an item removed from the queue.
	 * @return the current size of the queue.
	 */
	public int size();

	/**
	 * This method will return wether the queue is empty or not.
	 * False if is not empty, and true if it is empty.
	 * @return true if its not empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * this method is used to clear the whole queue.
	 * No matter the size, it will clear everything.
	 */
	public void clear();
}